function addSubject() {
    var subjectData = {
        subjectName: document.getElementById("subjectName").value,
        learningMaterials: document.getElementById("learningMaterials").value
    };

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/add-subject", true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                alert("Subject added successfully!");
                // Можно выполнить другие действия после успешного добавления
            } else {
                alert("Error adding subject: " + xhr.statusText);
            }
        }
    };
    xhr.send(JSON.stringify(subjectData));
}
