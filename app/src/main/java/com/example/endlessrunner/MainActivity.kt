package com.example.endlessrunner

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import kotlinx.coroutines.delay
import java.io.InputStream
import java.util.*
import kotlin.random.Random

class MainActivity : ComponentActivity() {

    private var bluetoothSocket: BluetoothSocket? = null
    private var inputStream: InputStream? = null

    private val isHardwareConnected = mutableStateOf(false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        connectBluetooth()

        setContent {
            EndlessRunnerGame(
                hardwareConnected = isHardwareConnected.value
            ) { move ->
                // move = 0 left, 1 right
            }
        }
    }

    private fun connectBluetooth() {
        try {
            val adapter = BluetoothAdapter.getDefaultAdapter()

            if (adapter == null || !adapter.isEnabled) {
                isHardwareConnected.value = false
                return
            }

            val device: BluetoothDevice =
                adapter.bondedDevices.firstOrNull() ?: run {
                    isHardwareConnected.value = false
                    return
                }

            val uuid = device.uuids?.firstOrNull()?.uuid ?: run {
                isHardwareConnected.value = false
                return
            }

            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.BLUETOOTH_CONNECT
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                isHardwareConnected.value = false
                return
            }

            bluetoothSocket = device.createRfcommSocketToServiceRecord(uuid)
            bluetoothSocket?.connect()

            inputStream = bluetoothSocket?.inputStream

            isHardwareConnected.value = true

        } catch (e: Exception) {
            e.printStackTrace()
            isHardwareConnected.value = false
        }
    }
}

data class Obstacle(val lane: Int, val y: Float)

@Composable
fun EndlessRunnerGame(
    hardwareConnected: Boolean,
    onHardwareMove: (Int) -> Unit
) {

    val lanes = 3
    var currentLane by remember { mutableStateOf(1) }
    var obstacles by remember { mutableStateOf(listOf<Obstacle>()) }
    var score by remember { mutableStateOf(0) }
    var gameOver by remember { mutableStateOf(false) }

    var speed by remember { mutableStateOf(5f) }
    var spawnCooldown by remember { mutableStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(Color(0xFF0F2027), Color(0xFF203A43))
                )
            )
    ) {

        Canvas(modifier = Modifier.fillMaxSize()) {

            val laneWidth = size.width / lanes
            val playerWidth = laneWidth / 2
            val playerHeight = 120f
            val playerY = size.height - 250f
            val playerX = laneWidth * currentLane + laneWidth / 4

            if (!gameOver) {

                obstacles = obstacles.map {
                    it.copy(y = it.y + speed)
                }.filter { it.y < size.height }

                spawnCooldown++

                if (spawnCooldown > 120 && obstacles.size < 2) {
                    val existingLanes = obstacles.map { it.lane }
                    val availableLanes =
                        (0 until lanes).filter { it !in existingLanes }

                    if (availableLanes.isNotEmpty()) {
                        obstacles += Obstacle(availableLanes.random(), 0f)
                        spawnCooldown = 0
                    }
                }

                obstacles.forEach { obs ->

                    val obstacleX =
                        laneWidth * obs.lane + laneWidth / 4

                    val collision =
                        playerX < obstacleX + playerWidth &&
                                playerX + playerWidth > obstacleX &&
                                playerY < obs.y + playerHeight &&
                                playerY + playerHeight > obs.y

                    if (collision) gameOver = true
                }

                score++
            }

            for (i in 1 until lanes) {
                drawLine(
                    color = Color.White.copy(alpha = 0.15f),
                    start = Offset(laneWidth * i, 0f),
                    end = Offset(laneWidth * i, size.height),
                    strokeWidth = 4f
                )
            }

            drawRoundRect(
                color = Color.Green,
                topLeft = Offset(playerX, playerY),
                size = Size(playerWidth, playerHeight)
            )

            obstacles.forEach {
                drawRoundRect(
                    color = Color.Red,
                    topLeft = Offset(
                        laneWidth * it.lane + laneWidth / 4,
                        it.y
                    ),
                    size = Size(playerWidth, playerHeight)
                )
            }
        }

        // Bluetooth Status Indicator
        Text(
            text = if (hardwareConnected)
                "Hardware Connected ✅"
            else
                "No Hardware Connection ❌",
            color = if (hardwareConnected) Color.Green else Color.Red,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
        )

        Text(
            text = "Score: $score",
            color = Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 50.dp)
        )

        if (!gameOver) {
            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(40.dp)
            ) {

                Button(
                    onClick = {
                        if (currentLane > 0) currentLane--
                        onHardwareMove(0)
                    },
                    shape = CircleShape,
                    modifier = Modifier.size(80.dp)
                ) {
                    Text("◀")
                }

                Spacer(modifier = Modifier.width(80.dp))

                Button(
                    onClick = {
                        if (currentLane < 2) currentLane++
                        onHardwareMove(1)
                    },
                    shape = CircleShape,
                    modifier = Modifier.size(80.dp)
                ) {
                    Text("▶")
                }
            }
        }

        AnimatedVisibility(
            visible = gameOver,
            modifier = Modifier.align(Alignment.Center)
        ) {
            Card(
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier
                    .padding(30.dp)
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "GAME OVER",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Red
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text("Final Score: $score")

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(onClick = {
                        currentLane = 1
                        obstacles = emptyList()
                        score = 0
                        speed = 5f
                        spawnCooldown = 0
                        gameOver = false
                    }) {
                        Text("RESTART")
                    }
                }
            }
        }
    }
}