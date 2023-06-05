export default class Shape extends HTMLElement {

    //called once the element is connected to the DOM
    connectedCallback() {
        //Custom logic
        this.render();
    }

    //called once the element is removed/disconnected from the DOM
    disconnectedCallback() {
        console.log("bye !");
    }

    render() {
        const shape = this.getAttribute("my-shape");//création d'un attribut
        const color = this.getAttribute("my-color");
        const content = this.getAttribute("content");
        const str = this.getAttribute("delay");
        const delay = parseInt(str, 10);
        setTimeout(() => {
            this.innerHTML = `
        <div class="${shape} ${color}"> ${content}</div>
        `;            
        }, delay); // apparition des carrés 1 par 1
    }
}


//customElements est prédéfinis
customElements.define("my-shape", Shape);//2 paramètres
//contrainte avoir un tiret dedans