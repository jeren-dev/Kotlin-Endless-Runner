# 🚀 Endless Runner Game

> **A futuristic Android endless runner game built using Kotlin + Jetpack Compose with Bluetooth (ESP32/Arduino) controller support.**

---

# 📌 Project Overview

**Endless Runner** is a fast-paced arcade game where players dodge obstacles across a **3-lane track**. The game supports both **touch controls** and **Bluetooth hardware controllers (ESP32/Arduino)**, providing an engaging hybrid gaming experience.

Featuring a **Cyberpunk Neon UI**, dynamic difficulty scaling, particle animations, and real-time Bluetooth communication, the game delivers a modern arcade experience on Android.

---

# ✨ Features

## 🎮 Game Mechanics

* ♾️ Endless infinite running gameplay
* 🛣️ 3-lane movement system
* 🚧 Multiple obstacle types
* 📈 Dynamic difficulty scaling
* 💥 Collision detection system
* 🏆 Local high score storage

---

## 🎯 Control System

* 📱 Touch controls (Left / Right)
* 📡 Bluetooth controller support (ESP32 / Arduino)
* 🔄 Dual input mode
* ⚡ Instant input switching

---

## 🎨 UI / UX

* 🌌 Cyberpunk Neon Theme
* 🪟 Glassmorphism panels
* ✨ Animated particle background
* 🎬 Smooth Compose animations
* 📱 Responsive layouts

---

## 📡 Bluetooth Integration

* 🔗 Connect ESP32 / HC-05 / HC-06
* 📤 Send commands
* 📥 Receive commands
* 📶 Live connection status
* 📱 Connected device display

---

# 🛠️ Tech Stack

| Technology   | Used                  |
| ------------ | --------------------- |
| Language     | Kotlin                |
| UI           | Jetpack Compose       |
| Architecture | MVVM                  |
| Bluetooth    | Android Bluetooth API |
| Concurrency  | Kotlin Coroutines     |
| Animation    | Compose Animation API |
| Minimum SDK  | Android 6.0 (API 23)  |

---

# 📂 Project Structure

```text
app/
└── src/
    └── main/
        └── java/
            └── com/example/endlessrunner/
                ├── MainActivity.kt
                ├── EndlessRunnerGame.kt
                ├── Obstacle.kt
                ├── Particle.kt
                ├── ControlButton.kt
                └── ControlModeChip.kt
```

---

# 🎮 Game Logic

## 🧍 Player Movement

* 3 lane system (0, 1, 2)
* Smooth lane switching
* Touch controls
* Bluetooth hardware controls

---

## 🚧 Obstacle System

* Random lane spawning
* Dynamic spawn rate
* Multiple obstacle types
* Fair obstacle generation

---

## 💥 Collision Detection

* Pixel-based collision
* 80% hitbox fairness
* Explosion particle effects
* Instant game over detection

---

## 🏆 Score System

* Continuous score increase
* Speed increases over time
* Spawn interval decreases
* Local high score saving

---

# 🎨 UI Design

## 🌈 Theme

* 🌌 Dark Cyberpunk Background
* 💙 Neon Cyan Highlights
* ✨ Glow Effects
* 🪟 Glassmorphism Cards

---

## ✨ Animations

* 🌟 Floating particles
* 💫 Pulsing glow
* 🛣️ Lane movement effects
* 📳 Game over shake animation

---

# 📱 Screens

| Screen             | Description                   |
| ------------------ | ----------------------------- |
| 🏁 Start Screen    | Play Game & Connect Bluetooth |
| 🎮 Gameplay        | Endless Runner Experience     |
| 💀 Game Over       | Score & Restart               |
| 📡 Bluetooth Panel | Device Connection             |
| 🔌 Hardware Setup  | Controller Configuration      |

---

# 🔌 Hardware Setup

## Required Components

* ESP32 / Arduino
* HC-05 / HC-06 Bluetooth Module
* 2 Push Buttons
* Jumper Wires
* Breadboard (Optional)

---

# 🔧 Circuit Diagram

```text
ESP32 / Arduino        HC-05 Bluetooth

VCC   ----------------> VCC
GND   ----------------> GND
TX    ----------------> RX
RX    ----------------> TX
```

### Push Buttons

```text
LEFT BUTTON   → GPIO 2
RIGHT BUTTON  → GPIO 3
```

---

# 🚀 Future Improvements

* 🎵 Background music & sound effects
* 👤 Multiple player skins
* 🌍 Online leaderboard
* 🏅 Achievement system
* 🎁 Daily rewards
* ☁️ Firebase cloud save
* 🎮 Gamepad support
* 🌎 Multiplayer mode

---

# 📸 Preview

> Add screenshots of:
>
> * 🏁 Start Screen
> * 🎮 Gameplay
> * 💀 Game Over Screen
> * 📡 Bluetooth Connection
> * 🔌 Hardware Setup

---

# 👨‍💻 Developed With

* ❤️ Kotlin
* 🎨 Jetpack Compose
* 📡 Android Bluetooth API
* ⚡ Kotlin Coroutines
* 🏗️ MVVM Architecture

---

# ⭐ If you like this project

Give this repository a **⭐ Star** and support the project!
