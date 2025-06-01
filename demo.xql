load $1 to doc                           // carrega xml do primeiro argumento
setid = doc.id                           // "demo"
courses = doc.course                     // [<course ..>..</course>,<course ..>..</course>]
elp = doc.course[0]                     // <course code="elp">..</course>
pacredits = doc.course[1].credits        // 6
elpeval = doc.course[0].evaluation       // [<item ..>, <item ..>]
total = doc.course#                      // 2
ids = doc.course->code[1]                   // ["elp","pa"]
credits = doc.course->credits++          // 12
xml = ***
<summary count="$total" credits="$credits">
    <uc$courses name="$code"/>
</summary>
***

save ids to $2                           // grava xml no segundo argumento