function updateUser() {
    var userId = document.getElementById("userId").value;

    var user = {
        id: userId,
        fullName: document.getElementById("fullName").value,
        mailboxAddress: document.getElementById("mailboxAddress").value,
        groupId: document.getElementById("groupId").value,
        jobTitle: document.getElementById("jobTitle").value,
        additionalJobTitle: document.getElementById("additionalJobTitle").value,
        isOnScholarships: document.getElementById("isOnScholarships").value,
        educationForm: document.getElementById("educationForm").value,
        subjectsId: document.getElementById("subjectsId").value
    };

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/user/update/" + userId, true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                alert("User updated successfully!");
                // Optionally, you can perform additional actions upon successful update
            } else {
                alert("Error updating user: " + xhr.statusText);
                // Optionally, you can handle the error scenario
            }
        }
    };
    xhr.send(JSON.stringify(user));
}
