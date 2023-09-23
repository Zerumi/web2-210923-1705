const VALID_CLASS_ID = "valid";
const INVALID_CLASS_ID = "invalid";
const ERROR_CLASS_ID = "error";
const ERROR_CLASS_ID_ACTIVATE = "error active";
const STRING_EMPTY = "";

const form = document.querySelector("form");
//const x_select = document.getElementById("x-select");
const y_select  = document.getElementById("y-select");
//const r_select = document.getElementById("r-select");

const y_error = y_select.nextElementSibling;

function containsNumberAfterDecimal(inputString) {
    // Define a regular expression pattern that matches a decimal point followed by a number from 1 to 9.
    const regex = /\.0+([1-9])/;

    // Use the test() method of the regular expression to check if the pattern exists in the inputString.
    return regex.test(inputString);
}

window.addEventListener("load", () => {
    const isValidY = y_select.value.length === 0 || !Number.isNaN(+y_select.value);
    y_select.className = isValidY ? VALID_CLASS_ID : INVALID_CLASS_ID;
});

// This defines what happens when the user types in the field
// nit: place single event handler on parent element // ???
y_select.addEventListener("input", () => {
    const y = +y_select.value;

    //console.log(y_select.value.includes("-3.") && containsNumberAfterDecimal(y_select.value));

    const isValid = y_select.value.length === 0 || y_select.value === "-"
        || (!Number.isNaN(y) && y >= -3 && y <= 5)
        && !(y_select.value.includes("-3.") && containsNumberAfterDecimal(y_select.value))
        && !(y_select.value.includes("5.") && containsNumberAfterDecimal(y_select.value));
    if (isValid) {
        y_select.className = VALID_CLASS_ID;
        y_error.textContent = STRING_EMPTY;
        y_error.className = ERROR_CLASS_ID;
    } else {
        y_select.className = INVALID_CLASS_ID;
    }
});

const radioButtons = document.querySelectorAll('input[name="r-select"]');

// Add event listener for each radio button
radioButtons.forEach((radioButton) => {
    radioButton.addEventListener('change', function () {
        // Check if this radio button is selected
        if (this.checked) {
            const selectedValue = this.value;
            console.log(`Selected value: ${selectedValue}`);

            // You can perform any actions you need with the selected value here
            drawBatmanByR(+selectedValue);
        }
    });
});

// Get all buttons with the name attribute "x-select"
const buttons = document.querySelectorAll('input[name="x-select"]');

// Add a click event listener to each button
buttons.forEach((button) => {
    button.addEventListener('click', function () {
        // Deselect all buttons
        buttons.forEach((btn) => {
            btn.classList.remove('selected');
        });

        // Select the clicked button
        this.classList.add('selected');

        // You can perform any actions you need with the selected value here
        const selectedValue = this.value;
        console.log(`Selected value: ${selectedValue}`);
    });
});


// This defines what happens when the user tries to submit the data
form.addEventListener("submit", (event) => {
    const y = +y_select.value;

    // no default sending data to form (it will be done using xmlhttp if js is activated)
    event.preventDefault();

    const isValidY = y_select.value.length === 0 || !Number.isNaN(y);
    const isAcceptableY = y >= -3 && y <= 5
        && !(y_select.value.includes("-3.") && containsNumberAfterDecimal(y_select.value))
        && !(y_select.value.includes("5.") && containsNumberAfterDecimal(y_select.value));
    if (!isValidY) {
        y_select.className = INVALID_CLASS_ID;
        y_error.textContent = "Expected as number, like -1";
        y_error.className = ERROR_CLASS_ID_ACTIVATE;
    } else if (!isAcceptableY) {
        y_select.className = INVALID_CLASS_ID;
        y_error.textContent = "Number should be between -3 and 5";
        y_error.className = ERROR_CLASS_ID_ACTIVATE;
    } else {
        y_select.className = VALID_CLASS_ID;
        y_error.textContent = STRING_EMPTY;
        y_error.className = ERROR_CLASS_ID;
    }



    if (isValidY && isAcceptableY) {
        //drawPoint(x_select.value, y, r);
        //getIsIntersects(x_select.value, y_select.value, r_select.value);

        // send data to back
    }
});