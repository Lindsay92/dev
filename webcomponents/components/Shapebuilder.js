export default class Shapebuilder extends HTMLElement {

    connectedCallback() {
        this.render();
        }

        render() {
            //build dynamically shape
            const str = this.getAttribute("number");
            const number = parseInt(str, 10);
            let content ="";
            for(let i = 0; i < number; i++) {
                content += `<my-shape delay="${i*1000}" content="${i}" my-shape="square" my-color="blue-shape"></my-shape></my-shape>`;
            }//delay="${i*1000}" fait référence au setTime affichage des carrés 1 par 1
            this.innerHTML = content;

        }

    }


customElements.define("shape-builder", Shapebuilder);
