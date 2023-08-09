    function registerUser() {

    var user = {
    fullName: document.getElementById("fullName").value,
    mailboxAddress: document.getElementById("mailboxAddress").value,
    userPassword: document.getElementById("userPassword").value,
    groupId: document.getElementById("groupId").value,
    jobTitle: document.getElementById("jobTitle").value,
    additionalJobTitle: document.getElementById("additionalJobTitle").value,
    isOnScholarships: document.getElementById("isOnScholarships").value,
    educationForm: document.getElementById("educationForm").value,
    subjectsId: document.getElementById("subjectsId").value


};

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/registration", true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhr.onreadystatechange = function () {
    if (xhr.readyState === 4) {
    if (xhr.status === 200) {
    alert("User registered successfully!");
} else {
    alert("Error registering user: " + xhr.statusText);
}
}
};
    xhr.send(JSON.stringify(user));
}
