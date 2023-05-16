function openFindBand() {
    // document.getElementById("test").innerHTML = "test";
    let bandName = document.getElementById("bandNameSearch").value;
    window.open(location.href.replaceAll('?', '') + "band?name=" + bandName, '_blank').focus();
}
