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
        <p>web2-210923-1705</p>
        <p>by Afanasyev Kirill Aleksandrovich, group no. P3206</p>
        <p>Variant no. 1611</p>
      </div>
      <div id="main" class="margin">
        <div id="choose" class="blured-container round-container margin">
          <p>Enter parameters:</p>
          <p><i>Notice!</i> <b>Every</b> parameter <b>should be filled!</b></p>
          <form method="get">
            <div id="x-select-container" class="select-container margin">
              <label for="x-select-input">Choose X:</label>
                <div id="x-select-input">
                  <input type="button" name="x-select" value="-5" />
                  <input type="button" name="x-select" value="-4" />
                  <input type="button" name="x-select" value="-3" />
                  <input type="button" name="x-select" value="-2" />
                  <input type="button" name="x-select" value="-1" />
                  <input type="button" name="x-select" value="0" />
                  <input type="button" name="x-select" value="1" />
                  <input type="button" name="x-select" value="2" />
                  <input type="button" name="x-select" value="3" />
                </div>
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
              <label for="r-select-input">Enter R:</label>
              <div id="r-select-input" class="select-radio-container">
                <input type="radio" id="r-select1" name="r-select" value="1" required />
                <label for="r-select1">1</label>
                <input type="radio" id="r-select2" name="r-select" value="2" />
                <label for="r-select2">2</label>
                <input type="radio" id="r-select3" name="r-select" value="3" />
                <label for="r-select3">3</label>
                <input type="radio" id="r-select4" name="r-select" value="4" />
                <label for="r-select4">4</label>
                <input type="radio" id="r-select5" name="r-select" value="5" />
                <label for="r-select5">5</label>
              </div>
            </div>
            <div id="submit-container" class="margin">
              <input type="submit" id="submit-button" value="Get disappointed in your life">
            </div>
          </form>
        </div>
        <div id="graph-container" class="blured-container round-container margin">
          <div id="graph"></div>
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
        <p>Copyright &#x00A9 Zerumi, 2023. Licensed under <a href="../LICENSE">ISC license</a>. Plagiarism is prohibited.</p>
      </div>
    </div>
    <script src="https://www.desmos.com/api/v1.8/calculator.js?apiKey=dcb31709b452b1cf9dc26972add0fda6"></script>
    <script src="scripts/graph.js"></script>
    <script src="scripts/validation.js"></script>
    <script src="scripts/fix-placeholder.js"></script>
  </body>
</html>