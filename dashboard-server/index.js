const express = require('express');
const path = require('path');
const app = express();
const PORT = 8000;

// Serve static files from the public directory
app.use(express.static(path.join(__dirname, 'public')));

// API endpoint example
app.get('/api/status', (req, res) => {
  res.json({ status: 'Dashboard server is running' });
});

// Serve the dashboard HTML
app.get('/', (req, res) => {
  res.sendFile(path.join(__dirname, 'public', 'index.html'));
});

app.listen(PORT, () => {
  console.log("Server is running on http://localhost:" + PORT);
});
