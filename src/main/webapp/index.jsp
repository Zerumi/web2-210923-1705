<!DOCTYPE html>
<html lang="en-US">
<head>
  <meta name="viewport" content="initial-scale=1.0" />
  <meta http-equiv="Content-Type" content="text/html" charset="UTF-8" />
  <link rel="stylesheet" href="styles/style.css">
  <title>web1-310823-1611</title>
</head>
<body>
<div id="container" class="margin">
  <div id="header" class="blured-container round-container margin">
    <p>web1-310823-1611</p>
    <p>by Afanasyev Kirill Aleksandrovich, group no. P3206</p>
    <p>Variant no. 1611</p>
  </div>
  <div id="main" class="margin">
    <div id="choose" class="blured-container round-container margin">
      <p>Enter parameters:</p>
      <p><i>Notice!</i> <b>Every</b> parameter <b>should be filled!</b></p>
      <form action="actions/check-hit.php" method="get">
        <div id="x-select-container" class="select-container margin">
          <label for="x-select">Choose X:</label>
          <select name="x-select" id="x-select" required>
            <option value="">-- Please choose an option--</option>
            <option value="-4">-4</option>
            <option value="-3">-3</option>
            <option value="-2">-2</option>
            <option value="-1">-1</option>
            <option value="0">0</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
          </select>
        </div>
        <div id="y-select-container" class="select-container margin">
          <label for="y-select">Enter Y:</label>
          <div id="y-select-input" class="select-input-container">
            <input type="text" name="y-select" id="y-select" class="input-select"
                   placeholder="Should be between -5 and 3" required />
            <span class="error" aria-live="polite"></span>
          </div>
        </div>
        <div id="r-select-container" class="select-container margin">
          <label for="r-select">Enter R:</label>
          <div id="r-select-input" class="select-input-container">
            <input type="text" name="r-select" id="r-select" class="input-select"
                   placeholder="Should be between 2 and 5" required />
            <span class="error" aria-live="polite"></span>
          </div>
        </div>
        <div id="submit-container" class="margin">
          <input type="submit" id="submit-button" value="Get disappointed in your life">
        </div>
      </form>
    </div>
    <div id="graph-container" class="blured-container round-container margin">
      <canvas id="graph" width="500px" height="500px"></canvas>
    </div>
    <div id="result-table-container" class="blured-container margin">
      <table id="result-table">
        <thead>
        <tr>
          <th>X</th>
          <th>Y</th>
          <th>R</th>
          <th>Result</th>
          <th>Executed at</th>
          <th>Execution time</th>
        </tr>
        </thead>
        <tbody></tbody>
      </table>
    </div>
  </div>
  <div id="footer" class="blured-container round-container margin">
    <p>Copyright © Zerumi, 2023. Licensed under <a href="LICENSE">ISC license</a>. Plagiarism is prohibited.</p>
  </div>
</div>
<script src="scripts/validation.js"></script>
<script src="scripts/fix-placeholder.js"></script>
</body>
</html>