🚀 Endless Runner Game

A futuristic endless runner Android game built using Kotlin + Jetpack Compose with Bluetooth hardware controller (ESP32/Arduino) support.

📌 Project Overview

Endless Runner is a fast-paced arcade game where players dodge obstacles in a 3-lane track.
It supports both touch controls and Bluetooth hardware controls, making gameplay more interactive and unique.

The game includes real-time Bluetooth communication, dynamic difficulty scaling, and a cyberpunk neon UI.

✨ Features
🎮 Game Mechanics
Endless infinite running gameplay
3-lane obstacle system
Dynamic difficulty increase over time
Multiple obstacle types
Collision detection system
High score tracking (local storage)


🎯 Control System
Touch screen controls (left / right buttons)
Bluetooth ESP32 / Arduino controller support
Dual input mode (both work together)
Real-time control switching


🎨 UI / UX
Cyberpunk neon theme
Glassmorphism UI effects
Animated background particles
Smooth transitions & animations
Responsive layout
📡 Bluetooth Integration
Connect ESP32 / HC-05 module
Real-time command communication
Connection status indicator
Device name display
Send & receive commands


🛠️ Tech Stack
Language: Kotlin
UI: Jetpack Compose
Architecture: MVVM
Bluetooth: Android Bluetooth API
Concurrency: Kotlin Coroutines
Animations: Compose Animation API
Min SDK: 23 (Android 6.0)


📂 Project Structure
app/src/main/java/com/example/endlessrunner/
├── MainActivity.kt
├── Obstacle.kt
├── Particle.kt
├── EndlessRunnerGame.kt
├── ControlButton.kt
├── ControlModeChip.kt


🎮 Game Logic
🧍 Player Movement
3 lanes (0, 1, 2)
Left / Right movement via touch or hardware
Smooth lane switching


🚧 Obstacle System
Random lane spawning
Increasing difficulty over time
Max obstacle control for fairness


💥 Collision System
Pixel-based hit detection
80% hitbox fairness logic
Explosion particle effect on crash


🏆 Score System
Score increases continuously
Speed increases with score
Spawn rate decreases gradually


🎨 UI Design
🌈 Theme Colors
Dark cyberpunk background
Cyan neon highlights
Glow effects
Glass UI panels


✨ Animations
Pulsing glow effects
Moving star background
Lane motion effects
Game over shake animation


📱 Screens
🏁 Start Screen (Play + Connect Bluetooth)
🎮 Gameplay Screen
💀 Game Over Screen
📡 Bluetooth Connection Panel
🔌 Hardware Setup


Components
ESP32 / Arduino
HC-05 / HC-06 Bluetooth module
Push buttons (2)
Jumper wires
Circuit
ESP32/Arduino → Bluetooth Module

VCC → VCC  
GND → GND  
TX  → RX  
RX  → TX  

Buttons:
Left  → PIN 2  
Right → PIN 3
