Endless Runner Game 🏃
A futuristic endless runner Android game built with Kotlin and Jetpack Compose with Bluetooth hardware controller support.

🚀 Project Overview
Endless Runner is a high-speed arcade game where players dodge obstacles in a three-lane track. The game features dual control options - touch screen controls and Bluetooth hardware controller (ESP32/Arduino) support, making it both accessible and interactive.

The game includes real-time Bluetooth communication, dynamic difficulty scaling, and a sleek cyberpunk-themed UI with neon glow effects.

✨ Features
🎮 Game Mechanics
Endless running with infinite gameplay

3-lane obstacle dodging system

Dynamic difficulty progression

Multiple obstacle types (Triangle, Square, Circle)

Collision detection with particle effects

High score tracking with local storage

🎯 Control Modes
Touch Controls: On-screen arrow buttons

Hardware Controls: Bluetooth ESP32/Arduino controller

Dual Mode: Both touch and hardware work simultaneously

Real-time Mode Switching: Toggle between control modes

🎨 UI/UX Features
Cyberpunk-themed design with neon glows

Glass morphism effect on cards

Animated background stars

Pulsing glow animations

Responsive layout for all screen sizes

Real-time Bluetooth command display

📡 Bluetooth Integration
Connect to ESP32/Arduino via Bluetooth

Receive real-time hardware commands

Send commands back to hardware

Connection status indicator

Device name display

🛠️ Technologies Used
Language: Kotlin

UI Framework: Jetpack Compose

Architecture: MVVM with Clean Architecture

Bluetooth: Android Bluetooth API

Concurrency: Kotlin Coroutines

Animations: Compose Animation API

Minimum SDK: Android 6.0 (API 23)

📂 Project Structure
text
app/src/main/java/com/example/endlessrunner/
├── MainActivity.kt              # Main game activity with Bluetooth
├── Data Classes
│   ├── Obstacle.kt              # Obstacle model with types
│   └── Particle.kt              # Particle system for effects
├── UI Components
│   ├── EndlessRunnerGame.kt     # Main game composable
│   ├── ControlButton.kt         # Touch control buttons
│   └── ControlModeChip.kt       # Mode selector chips
└── Bluetooth Manager
    └── (Integrated in MainActivity)
🎮 Game Logic
Player Movement
Player moves between 3 lanes (0, 1, 2)

Touch buttons or hardware commands trigger movement

Smooth lane switching with visual feedback

Obstacle System
kotlin
// Obstacle spawn logic
spawnCooldown++
val spawnRate = maxOf(60, 120 - (score / 10))

if (spawnCooldown > spawnRate && obstacles.size < 3) {
    val availableLanes = (0 until lanes).filter { 
        it !in obstacles.map { it.lane } 
    }
    obstacles += Obstacle(availableLanes.random(), -playerHeight)
}
Collision Detection
Pixel-perfect hitbox detection

80% hitbox size for fair gameplay

Triggers explosion particles on collision

Score & Difficulty
Score increases every frame

Speed increases with score (8f → 18f)

Spawn rate decreases with score

🎨 UI Design
Theme Colors
kotlin
// Cyberpunk Theme
Color(0xFF0A0F1E)      // Background
Color.Cyan             // Primary accent
Color.Blue             // Secondary accent
Color.White            // Text color
Color.Cyan.copy(alpha) // Glow effects
Animations
Glow Effect: Pulsing cyan glow on UI elements

Stars: Animated background particles

Lane Lines: Moving dashed lines with parallax

Game Over: Screen shake effect

Transitions: Smooth fade and scale animations

📱 Screens
Start Screen: Game title with instructions and connect button

Gameplay: Main game canvas with controls

Game Over: Score display with restart and menu options

Bluetooth: Connection status and control mode selector

🔌 Hardware Setup
Components Required
ESP32 or Arduino board

HC-05 or HC-06 Bluetooth module

2 Push buttons

Jumper wires

Breadboard

Circuit Diagram
text
ESP32/Arduino      HC-05/06 Bluetooth Module
┌─────────────┐    ┌─────────────────────┐
│ VCC (3.3V)  ├────┤ VCC                 │
│ GND         ├────┤ GND                 │
│ TX (10)     ├────┤ RX                  │
│ RX (11)     ├────┤ TX                  │
└─────────────┘    └─────────────────────┘

Push Buttons:
LEFT Button → PIN 2 (with pull-up)
RIGHT Button → PIN 3 (with pull-up)
Arduino/ESP32 Code
cpp
#include <SoftwareSerial.h>

SoftwareSerial bluetooth(10, 11); // RX, TX

const int LEFT_BUTTON = 2;
const int RIGHT_BUTTON = 3;

void setup() {
  Serial.begin(9600);
  bluetooth.begin(9600);
  
  pinMode(LEFT_BUTTON, INPUT_PULLUP);
  pinMode(RIGHT_BUTTON, INPUT_PULLUP);
  
  Serial.println("Controller Ready!");
}

void loop() {
  // Send left command
  if(digitalRead(LEFT_BUTTON) == LOW) {
    bluetooth.println("L");
    delay(200);
  }
  
  // Send right command
  if(digitalRead(RIGHT_BUTTON) == LOW) {
    bluetooth.println("R");
    delay(200);
  }
}
📡 Bluetooth Commands
Commands Sent from Hardware
Command	Action
L, l, LEFT, 0	Move player left
R, r, RIGHT, 1	Move player right
Commands Sent to Hardware
Command	Purpose
0	Move left signal
1	Move right signal
🔧 Setup Instructions
1. Clone Repository
bash
git clone https://github.com/jeren-dev/endless-runner.git
cd endless-runner
2. Update MAC Address
kotlin
// In MainActivity.kt
private val ESP32_MAC = "20:E7:C8:9E:4E:76" // 🔥 Replace with your ESP32 MAC
3. Pair Bluetooth Device
Go to Android Settings → Bluetooth

Turn on Bluetooth

Pair with ESP32/HC-05 device

Default PIN: 1234 or 0000

4. Build & Run
Open project in Android Studio

Click Run or press Shift + F10

Grant Bluetooth permissions

Click "Connect" in the app

🐛 Troubleshooting
Issue	Solution
Can't connect to ESP32	Check MAC address, ensure Bluetooth is ON, pair device first
No data received	Verify baud rate (9600), check wiring, restart ESP32
Connection timeout	Move closer to ESP32, check power supply
App crashes	Clear app cache, restart device, check permissions
Laggy gameplay	Close background apps, reduce obstacle count
UI glitches	Update Android Studio, rebuild project
🔮 Future Improvements
Multiplayer mode via Bluetooth

Power-ups and collectibles

Different game environments

Sound effects and background music

Cloud high score sync

Customizable player skins

Leaderboard integration

Gesture controls

Haptic feedback

AR mode integration

📊 Performance Optimizations
Efficient particle system

Object pooling for obstacles

Optimized canvas rendering

Battery-aware animations

Memory leak prevention

👨‍💻 Developer
github.com/jeren-dev

GitHub: @jeren-dev

Project: Endless Runner

📄 License
This project is for learning and development purposes. MIT License - Free to use, modify, and distribute.

🙏 Acknowledgments
Jetpack Compose for modern UI

Kotlin Coroutines for async operations

Android Bluetooth API for hardware integration

Open-source community for various resources

Made with ❤️ and Kotlin
