// function openFindBand() {
//     // document.getElementById("test").innerHTML = "test";
//     let bandName = document.getElementById("bandNameInput").value;
//     window.open(location.href.replaceAll('?', '') + "band?name=" + bandName, '_blank').focus();
//     addText(bandName);
// }

function addText() {
    let bandName = document.getElementById("bandNameInput").value;
    let target = document.getElementById("bottomText");
    let text = target.innerHTML;
    target.innerHTML = bandName + " : " + new Date().toLocaleTimeString() + "<br>" + text;
    updateElement();
    // target.contentWindow.location.reload();
}

function updateElement() {
    $("#bottomText").load(window.location.href + " #bottomText");
}