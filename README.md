# Endless Runner Game 🏃

A futuristic endless runner Android game built with Kotlin and Jetpack Compose with Bluetooth hardware controller support.

## 🚀 Project Overview

Endless Runner is a high-speed arcade game where players dodge obstacles in a three-lane track. The game features dual control options - touch screen controls and Bluetooth hardware controller (ESP32/Arduino) support.

## ✨ Features

### 🎮 Game Mechanics
- Endless running with infinite gameplay
- 3-lane obstacle dodging system
- Dynamic difficulty progression
- Multiple obstacle types (Triangle, Square, Circle)
- Collision detection with particle effects
- High score tracking with local storage

### 🎯 Control Modes
- **Touch Controls**: On-screen arrow buttons
- **Hardware Controls**: Bluetooth ESP32/Arduino controller
- **Dual Mode**: Both touch and hardware work simultaneously
- **Real-time Mode Switching**: Toggle between control modes

### 🎨 UI/UX Features
- Cyberpunk-themed design with neon glows
- Glass morphism effect on cards
- Animated background stars
- Pulsing glow animations
- Real-time Bluetooth command display

### 📡 Bluetooth Integration
- Connect to ESP32/Arduino via Bluetooth
- Receive real-time hardware commands
- Send commands back to hardware
- Connection status indicator

## 🛠️ Technologies Used

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Architecture**: MVVM with Clean Architecture
- **Bluetooth**: Android Bluetooth API
- **Concurrency**: Kotlin Coroutines
- **Animations**: Compose Animation API
- **Minimum SDK**: Android 6.0 (API 23)

## 📂 Project Structure
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
