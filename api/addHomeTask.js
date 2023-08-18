function saveHomework() {
    var homeworkData = {
        dueDate: document.getElementById("dueDate").value,
        homeworksDescription: document.getElementById("homeworksDescription").value,
        links: document.getElementById("links").value,
        additionalMaterials: document.getElementById("additionalMaterials").value
    };

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/create-home-work", true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                alert("Homework saved successfully!");
                // Можно выполнить другие действия после успешного сохранения
            } else {
                alert("Error saving homework: " + xhr.statusText);
            }
        }
    };
    xhr.send(JSON.stringify(homeworkData));
}
