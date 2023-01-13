$().ready(() => {
    let bubbleWidth = 38;
    let sumWidth = $(".bubbles").width();
    let sumBubble = sumWidth / bubbleWidth
    let random = (l,r) => {
        return Math.random() * (r - l) + l;
    };
    let trasRange = {
        left: 3,
        right: 15
    };
    let delayRange = {
        left: 0,
        right: 3
    }
    let tras;
    let delay;
    for(let i = 0;i < sumBubble;i++) {
        tras = random(trasRange.left,trasRange.right);
        delay = random(delayRange.left,delayRange.right);
        $(`<div class="bubble" style="--tras:${tras};--delay:${delay}"></div>`).appendTo(".bubbles");
    }
});