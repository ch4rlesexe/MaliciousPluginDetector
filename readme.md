

## 🛡️ SuspiciousPlugin

### 📄 Description

> **SuspiciousPlugin** is a deliberately crafted **test plugin** designed to simulate suspicious behavior patterns. It is **100% safe** and meant solely for **validating Minecraft plugin scanners**, like your `MaliciousPluginScanner`.

---

### 🔍 Why This Plugin Exists

Many security tools (like yours) scan `.jar` files for risky code patterns, such as:

* `Class.forName(...)` → used in reflection exploits
* `Method.invoke(...)` → dynamic method execution
* `java.net.*` classes → potential for remote code/data transfer
* `sun.misc.Unsafe` → memory-level manipulation

While these patterns are **not inherently dangerous**, they **are common in obfuscated malware**, making them ideal markers for testing.

---

### ✅ What This Plugin Does

* Loads normally on a Minecraft Paper server
* Runs harmless Java reflection and network connection logic
* Logs fake "suspicious behavior"
* **Triggers your scanner** by design

---

### 🔒 What This Plugin Does **NOT** Do

* No actual command registration
* No file manipulation
* No network calls to real servers
* No data storage or user tracking
* No runtime effects beyond console logging

---

### 🧪 Usage

1. Build and place `SuspiciousPlugin.jar` in your `plugins/` folder.
2. Start your server with your `MaliciousPluginScanner` active.
3. Watch for the plugin to be flagged as containing:

   * Reflection usage
   * Network-related class references

---

