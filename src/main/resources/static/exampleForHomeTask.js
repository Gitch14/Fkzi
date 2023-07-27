/*
<!-- Подключаем CKEditor -->
<script src="https://cdn.ckeditor.com/4.16.2/standard/ckeditor.js"></script>

<!-- Создаем поле для редактирования текста -->
<textarea id="editor" name="editorData"></textarea>

<!-- Кнопка для отправки AJAX-запроса -->
<button onclick="sendData()">Отправить данные</button>

<script>
    // Инициализируем CKEditor
    CKEDITOR.replace('editor');

    // Функция для отправки данных на сервер
    function sendData() {
    // Получаем содержимое из CKEditor
    const editorData = CKEDITOR.instances.editor.getData();

    // Создаем объект с данными для отправки на сервер
    const data = {
    editorData: editorData
};

    // Создаем новый XMLHttpRequest объект
    const xhr = new XMLHttpRequest();

    // Устанавливаем обработчик события для получения ответа от сервера
    xhr.onreadystatechange = function () {
    if (xhr.readyState === XMLHttpRequest.DONE) {
    if (xhr.status === 200) {
    // Здесь обрабатываем успешный ответ от сервера
    console.log(xhr.responseText);
} else {
    // Здесь обрабатываем ошибку
    console.error('Произошла ошибка:', xhr.status, xhr.statusText);
}
}
};

    // Открываем соединение и отправляем POST-запрос на URL вашего сервера
    xhr.open('POST', '/api/hometasks', true);
    xhr.setRequestHeader('Content-Type', 'application/json');

    // Преобразуем данные в формат JSON и отправляем на сервер
    xhr.send(JSON.stringify(data));
}
</script>
*/