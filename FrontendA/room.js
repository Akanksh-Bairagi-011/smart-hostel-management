const AC=document.getElementById("filter-ac");
const beds=document.getElementById("filter-beds");
const floor=document.getElementById("filter-floor");

const clear=document.getElementById("clear-filters");

const roomCards=document.querySelectorAll(".room-card");

console.log("Hello");
console.log(roomCards);
console.log(roomCards[1].dataset.ac);

AC.addEventListener("change",Filter);
beds.addEventListener("change",Filter);
floor.addEventListener("change",Filter);

function Filter(){
    const selectedAC = AC.value;
    const selectedBeds = beds.value;
    const selectedFloor = floor.value;
    // Values of 

    roomCards.forEach((room)=>{
        const d_ac=room.dataset.ac;
        const d_beds=room.dataset.beds;
        const d_floor=room.dataset.floor;
        // Data of the rooms card

        if((selectedAC === "" || d_ac===selectedAC) && 
        (selectedBeds=== "" || d_beds===selectedBeds) &&
        (selectedFloor==="" || d_floor===selectedFloor))
        {
            room.style.display = "block";

        }
        else
         room.style.display = "none";
    });
}

