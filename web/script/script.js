function openFindBand() {
    // document.getElementById("test").innerHTML = "test";
    let bandName = document.getElementById("bandName").value;
    window.open('/band?name=' + bandName, '_blank').focus();
}
