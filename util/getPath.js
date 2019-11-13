function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

async function getPath() {
    for (let i = 20; i < 44; i++) {
        for (let j = 0; j < 44; j++) {
            if (i == j) {
                continue;
            }
            document.querySelector("#Station_From").selectedIndex = i + 1;
            document.querySelector("#Station_To").selectedIndex = j + 1;
            document.querySelector("#find_station").click()
            await sleep(2000);
            let tmp = [];
            tmp.push(document.querySelector("#Station_From").selectedOptions[0].innerText);
            tmp.push(document.querySelector("#Station_To").selectedOptions[0].innerText);
            tmp.push(document.querySelector("#refoResult1_1 > span.infoLtxt.col-md-8").innerText);
            tmp.push(document.querySelector("#refoResult1_2 > span.infoRtxt.col-md-8").innerText);
            tmp.push(document.querySelector("#farerate > tbody > tr:nth-child(1) > td:nth-child(2)").innerText);
            tmp.push(document.querySelector("#timelasp").innerText);
            console.log(tmp);
        }
    }
    return out;
}
getPath();


























//ARL
async function getPath() {
    let out = [];
    for (let i = 0; i < 8; i++) {
        for (let j = 0; j < 8; j++) {
            if (i == j) {
                continue;
            }
            document.querySelector("#station_start").selectedIndex = i + 1;
            document.querySelector("#station_last").selectedIndex = j + 1;
            calculate();
            await sleep(2000);
            let tmp = [];
            tmp.push(document.querySelector("#startdiv").innerText);
            tmp.push(document.querySelector("#lastdiv").innerText);
            tmp.push(document.querySelector("#total_price").innerText);
            tmp.push(document.querySelector("#totaltime").innerText);
            out.push(tmp);
        }
    }
    return out;
}
console.log(getPath());