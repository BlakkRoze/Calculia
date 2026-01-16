# Calculia

A node-based calculator application built with JavaFX that allows users to create computation graphs using arbitrary-precision rational numbers.

![Java](https://img.shields.io/badge/Java-25-orange)
![JavaFX](https://img.shields.io/badge/JavaFX-25.0.1-blue)
![Maven](https://img.shields.io/badge/Maven-Project-red)
![License](https://img.shields.io/badge/License-MIT-green)

---

## ✨ Features

- 🔢 **Arbitrary Precision Arithmetic** - Uses `BigInteger`-based fractions for exact calculations
- 🔗 **Node-based Computation Graph** - Connect nodes to build complex calculations
- ♻️ **Automatic Dependency Tracking** - Nodes automatically invalidate when dependencies change
- 🛡️ **Cycle Detection** - Prevents circular dependencies using graph algorithms
- ⚠️ **Robust Error Handling** - Division by zero and other errors handled gracefully
- 📝 **Live Editing** - Edit node values and connections in real-time
- 🎨 **Modern UI** - Clean JavaFX interface with FontAwesome icons
- 🔄 **Manual Evaluation** - Control when calculations are performed

---

## 🚀 Getting Started

### Prerequisites

- **Java 25** or higher
- **Maven 3.8+** (for building from source)
- **Git** (for cloning the repository)

### Quick Start

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/calculia.git
   cd calculia
   ```

2. **Build the project**
   ```bash
   mvn clean install
   ```

3. **Run the application**
   ```bash
   mvn javafx:run
   ```

### Alternative: Run from .jar
```bash
java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml -jar target/Calculia-0.1.jar
```

## 📖 Usage

### Creating Nodes

1. Click **"Add Node"** button
2. Select operation type from dropdown
3. Enter node ID and parameters
4. Click **"OK"**

### Editing Node Dependencies

1. Click on the text field showing the dependency ID
2. Type the new node ID
3. Press Enter

### Evaluating Calculations

1. Set up your node graph
2. Click **"Evaluate"** button
3. All nodes will calculate their results

---

## 🔢 Node Types

| Icon | Type | Description | Example |
|------|------|-------------|---------|
| 🏷️ | **Val** | Constant value | `42` or `22/7` |
| ➕ | **Add** | Addition | `node1 + node2` |
| ➖ | **Sub** | Subtraction | `node1 - node2` |
| ✖️ | **Mul** | Multiplication | `node1 × node2` |
| ➗ | **Div** | Division | `node1 ÷ node2` |
| 🔽 | **Min** | Minimum | `min(node1, node2)` |
| 🔼 | **Max** | Maximum | `max(node1, node2)` |
| ➖ | **Neg** | Negation | `-node` |

### Value Format

Values can be entered as:
- **Integers**: `42`, `-17`, `0`
- **Fractions**: `22/7`, `1/3`, `-5/2`

Results are automatically simplified to lowest terms.

---

## 🔨 Building from Source

### Build Commands

```bash
# Clean and compile
mvn clean compile

# Package as JAR
mvn package

# Run the application
mvn javafx:run

```

### Build Output

- **JAR file**: `target/Calculia-0.1.jar`

---

## 🛠️ Technologies

### Core Technologies
- **Java 25** - Programming language
- **JavaFX 25.0.1** - UI framework
- **Maven** - Build and dependency management

### Libraries
- **Ikonli 12.4.0** - Icon library (FontAwesome 5)
- **JUnit Jupiter 6.0.2** - Testing framework

---

## 🧮 How It Works

### Computation Flow

1. **User creates nodes** with values or operations
2. **Dependencies are set** by entering node IDs
3. **Observer pattern** tracks which nodes depend on others
4. **User clicks Evaluate**
5. **Nodes calculate** their results from dependencies
6. **UI updates** to show new values

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 🙏 Acknowledgments

- JavaFX team for the excellent UI framework
- Ikonli project for beautiful icons
- Stack Overflow community for problem-solving help

---

## 📚 Additional Resources

- [JavaFX Documentation](https://openjfx.io/)
- [Maven Documentation](https://maven.apache.org/)

---

**Made with ☕ and Java**
