## Commands
---
A tryout to [Fly.io](https://fly.io/docs/) platform for a single region.

### Build

To test application building locally:
```bash
$> cargo build
```

### Run - Locally

To run application locally:
```bash
$> cargo run
```
Navigate to [http://localhost:8080](http://localhost:8080) from local browser.

### Deploy to fly.io
```bash
$> fly launch
```

### Save fly machine config
```bash
$> fly save -o
```

### Restart flyio machine
```bash
# given `fly.toml` is in current directory
$> fly start
```

### Shell into fly machine
```bash
# given `fly.toml` is in current directory
$> flyctl ssh console
# OR
$> flyctl ssh console -t ${ACCESS_TOKEN}
```
