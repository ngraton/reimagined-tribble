# Buddy Pet Mod 🐾

A parent-child coding project: a cute pet companion for Minecraft!

**Two versions included:**
- **Java Edition** (Mac/PC) - Full-featured Fabric mod
- **Bedrock Edition** (iPad/Console) - Add-On pack

---

## Java Edition (Fabric Mod)

### Requirements
- Minecraft Java Edition 1.20.4
- Fabric Loader 0.15.9+
- Fabric API
- Java 17+

### Building & Testing
```bash
# Build the mod
./gradlew build

# Run Minecraft with the mod (for testing)
./gradlew runClient
```

The mod JAR will be in `build/libs/`

### How to Use
1. Get the mod JAR into your `mods` folder
2. Start Minecraft with Fabric
3. Find "Buddy Spawn Egg" in Creative mode (Spawn Eggs tab)
4. Spawn your buddy!
5. Give it a **cookie** to tame it 🍪
6. Right-click to toggle sitting

---

## Bedrock Edition (Add-On)

### Files
Located in `bedrock_addon/`:
- `behavior_pack/` - Controls pet behavior (AI, taming, etc.)
- `resource_pack/` - Controls appearance (model, texture)

### Installing on iPad
1. Zip each pack folder separately (or use `.mcpack` extension)
2. Transfer to iPad (AirDrop, email, cloud storage)
3. Tap the file to import into Minecraft
4. Create/edit a world → Settings → Add-Ons
5. Activate both packs

### How to Use
1. Use spawn egg or `/summon buddypet:buddy`
2. Give it a **cookie** to tame
3. Tap to toggle sitting

---

## Features (Sprint 1)

| Feature | Java | Bedrock |
|---------|------|---------|
| Follows player | ✅ | ✅ |
| Tame with cookies | ✅ | ✅ |
| Sit/stand toggle | ✅ | ✅ |
| Spawn egg | ✅ | ✅ |
| Custom texture | ✅ | ✅ |

## Future Ideas (Backlog)
- [ ] Custom sounds
- [ ] Special abilities
- [ ] Different buddy colors/variants
- [ ] Baby buddies
- [ ] Your ideas here!

---

*Built with ❤️ by a parent-child coding team*
