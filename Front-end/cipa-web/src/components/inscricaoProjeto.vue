<template>
  <div class="content-index">
    <div class="division-1">
      <img src="https://i.imgur.com/HcLNjzn.png" class="logo" />
      <div class="texts">
        <mark class="marki"
          ><p>Bem vindo ao CIPA</p>
          Por favor, insirerir os dados<br />
          do projeto para se inscrever.</mark
        >
      </div>
      <div class="agroup">
        <div class="row" style="width: 248%">
          <div id="grupo" class="input-field col s12">
            <i class="material-icons prefix">group</i>
            <select v-model="equipe" multiple>
              <option
                v-bind:value="i.id"
                selected="{{option == equipe}}"
                v-for="i of values"
                :key="i.id"
              >
                {{ i.nome }}
              </option>
            </select>
          </div>
        </div>
        <div id="imagem">
          <div class="row" style="width: 248%">
            <div class="input-field col s12">
              <i class="material-icons prefix">category</i>
              <select v-model="categoria" multiple>
                <option
                  v-bind:value="i"
                  v-bind:key="i"
                  selected="{{option == categoria}}"
                  v-for="i of temas"
                >
                  {{ i }}
                </option>
              </select>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="input-field col s6">
            <i class="material-icons prefix">title</i>
            <input
              id="títuloProjeto"
              v-model="tituloProjeto"
              type="text"
              class="imagem"
              placeholder="Título do projeto:"
              required
            />
          </div>
        </div>
        <div class="row">
          <div class="input-field col s6">
            <i class="material-icons prefix">link</i>
            <input
              class="imagem"
              id="linkVídeo"
              v-model="LinkDoVideo"
              type="text"
              placeholder="Link do vídeo:"
            />
          </div>
        </div>

        <div class="row">
          <div class="input-field col s6">
            <input
              v-on:click="enviar()"
              id="imagem"
              class="imagem"
              placeholder="Imagem:"
              type="file"
              @change="selectFile"
            />
            <label for="imagem"
              ><i class="material-icons prefix">photo</i></label
            >
          </div>
        </div>
        <br />
        <div class="row">
          <div class="input-field col s6">
            <i id="documento" class="material-icons prefix">description</i>
            <textarea
              id="descricao"
              v-model="descricao"
              placeholder="Descrição"
              maxlength="700"
              name="descrendoProjeto"
            ></textarea>
          </div>
        </div>
        <div class="row2">
          <button
            v-on:click="inscrever()"
            :disabled="!tituloProjeto || !descricao"
            class="btn waves-effect waves-light"
            type="submit"
            name="action"
          >
            INSCREVER
            <i class="material-icons right">send</i>
          </button>
        </div>
        <div class="has-login">
          <p>Você já tem uma conta? <a v-on:click="entre()">Entre.</a></p>
        </div>
      </div>
    </div>
    <div class="division-2">
      <img src="undraw_product_teardown_elol-removebg-preview.png" />
      <h1 class="titulo">CIPA</h1>
      <p class="subtitulo">
        Concurso de ideias<br />
        professor anjo
      </p>
    </div>
  </div>
</template>

<script>
import M from "materialize-css";
import { add } from "../Helpers/ideia";
import { getLocalStorage } from "../Helpers/localStore";
import { getAll } from "../Helpers/pessoas";

export default {
  name: "inscricaoProjeto",
  data() {
    return {
      id: getLocalStorage("id"),
      categoria: [],
      equipe: [],
      tituloProjeto: "",
      LinkDoVideo: "",
      descricao: "",
      linkImagem: null,
      imgBase64: "",
      values: [],
      temas: [
        "Erradicação da Pobreza",
        "Água e Sarneamento Básico",
        "Fome",
        "Saúde e Bem Estar",
        "Educação",
        "Igualdade de Gênero",
        "Água e Saneamento Básico",
        "Energia Sustentável",
        "Emprego e Economia",
        "Indústria, Inovação e Infraestrutura",
        "Redução de Desigualdade",
      ],
    };
  },
  async created() {
    const { pessoas } = await getAll();
    this.values = pessoas;
  },
  updated() {
    M.AutoInit();
  },
  async mounted() {
    M.AutoInit();
  },
  methods: {
    selectFile(e) {
      this.linkImagem = e.target.files[0];
      const reader = new FileReader();
      let rawImg;
      reader.onloadend = () => {
        rawImg = reader.result;
        this.imgBase64 = rawImg;
      };
      reader.readAsDataURL(this.linkImagem);
    },
    async inscrever() {
      const id = localStorage.getItem('id')
      let title = ''
      this.categoria.forEach(e => {
        title += e + ', '
      });
      console.log('id_lider',id);
      console.log('nome', this.tituloProjeto)
      const objIdeia = {
        id_lider: 1,
        id_concurso: 1,
        nome: this.tituloProjeto,
        imagem: this.imgBase64,
        resumo_do_projeto: this.descricao,
        temas_Impactados: title,
        video_demostrativo: this.LinkDoVideo,
      };
      console.log(objIdeia)
      await add(objIdeia);
      // this.$router.push("/");
    },
    entre() {
      this.$router.push("/");
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#documento {
  margin-top: -3%;
}

label {
  margin-top: -5%;
}

.imagem {
  width: 185% !important;
  margin-left: 16% !important;
}

@import url("https://fonts.googleapis.com/css2?family=Poppins&family=Rubik&family=Rubik+Mono+One&display=swap");

* {
  margin: 0;
  padding: 0;
}
.agroup {
  width: 40%;
}
#descricao {
  border: 1px solid #1b2f49;
  margin-top: -3%;
  width: 185%;
}

@media (max-width: 720px) {
  #descricao {
    border: 1px solid #1b2f49;
  }
  select#usuario {
    width: 145% !important;
    margin-left: 42% !important;
    margin-top: -19% !important;
  }
  #tipo {
    margin-top: 2% !important;
    margin-left: 18% !important;
  }
  .division-2 {
    display: none;
  }

  .texts {
    width: 200%;
    margin-top: -15% !important;
    margin-left: 58% !important;
    margin-left: 8%;
  }

  .agroup {
    margin-left: 15%;
  }

  .logo {
    margin-left: 52% !important;
  }

  .forgot-pass {
    width: 200%;
    margin-left: 127% !important;
  }
  div.row2 {
    margin-top: 15% !important;
    margin-left: 65% !important;
  }
  .has-login {
    width: 200% !important;
    margin-left: 48% !important;
  }

  .content-index {
    height: 400% !important;
  }
}

.forgot-pass p {
  color: #000080;
  font-family: "Poppins", Arial;
  font-size: 14px;
}
.forgot-pass {
  margin-left: 57%;
}
.has-login p {
  color: black;
  font-family: "Poppins", Arial;
  font-size: 14px;
  width: 200%;
  margin-left: 110%;
}
.has-login mark {
  background-color: transparent;
  color: #000080;
  font-family: "Poppins", Arial;
  font-size: 14px;
  font-weight: 800;
}
.has-login {
  margin-left: 31%;
  margin-top: 2%;
}
html {
  padding: 0;
  margin: 0;
}
#app {
  margin: 0;
  padding: 0;
}

.content-index {
  display: flex;
  width: 100%;
  height: 100vh;
}
.media-icons {
  margin-left: 20%;
  margin-top: 12%;
}
.subtitulo {
  font-family: "Rubik", sans-serif;
  font-size: 47px;
  text-shadow: 4px 4px 4px #000000;
  margin-left: 30%;
}
.media-icons i {
  font-size: 2.8rem;
  margin-left: 14%;
}

.division-1 {
  width: 43.3vw;
}
.division-1 img {
  width: 280px;
  margin-left: 34%;
}
.texts p {
  font-family: "Poppins", Arial;
  font-size: 24px;
  color: #1b2f49;
}
.texts mark,
a {
  background-color: #fff;
  color: #1b2f49;
  font-weight: bold;
  font-size: 14px;
}
.logo {
  margin-bottom: 4%;
  margin-left: 32% !important;
}
.texts {
  margin-left: 32%;
  margin-top: -8%;
}

.agroup {
  margin-top: 5% !important;
}

.row {
  margin-left: 20% !important;
  width: 100vh;
}
.row2 {
  margin-left: 38% !important;
  margin-top: 3%;
}
.row2 button {
  background-color: #1b2f49 !important;
  padding-left: 45px;
  padding-right: 45px;
  margin-left: 117%;
  margin-bottom: 5%;
  margin-top: 5%;
}

.division-2 {
  background-color: #cddae2;
  margin-top: -4%;
  width: 2000%;
  height: 146vh;
  margin-left: 7.5%;
}
.division-2 img {
  width: 680px;
  margin-top: 6%;
  margin-left: 5%;
}
.titulo {
  width: 185% !important;
  font-family: "Rubik Mono One", sans-serif;
  font-size: 86px;
  margin-top: -4%;
  margin-left: -32% !important;
}
input {
  border: solid 0.3vh #1c2c44 !important;
  text-align: left !important;
  height: 30px !important;
  margin-top: 2% !important;
  border-radius: 5px !important;
}
@media (max-width: 580px) {
  .division-2 {
    background-color: #fff;
  }
  .content-index {
    border: 2px solid black;
    height: 105vh;
    width: 520px;
    margin-left: 4% !important;
  }
  .logo {
    margin-bottom: 6%;
    margin-left: 65% !important;
  }
  .division-1 img {
    width: 240px;
    margin-left: 25%;
  }
  .media-icons {
    margin-left: 10%;
    margin-top: 6%;
  }
  .media-icons i {
    font-size: 2.8rem;
    margin-left: 14%;
  }
  .texts {
    margin-left: 16%;
    margin-top: -6%;
  }
  .agroup {
    margin-top: 5% !important;
  }

  .row {
    margin-left: 21% !important;
    width: 560%;
  }
  .row2 {
    margin-left: 21% !important;
  }
  .row2 button {
    background-color: #1b2f49 !important;
    padding-left: 35px;
    padding-right: 35px;
    margin-left: 295%;
  }
  .division-2 img {
    width: 0px;
    margin-top: 17%;
    margin-left: 18%;
  }
  .content-index {
    margin-left: 13%;
  }

  #descricao {
    margin-left: 16% !important;
    width: 185% !important;
  }
  #documento {
    margin-left: -0% !important;
  }

  #imagem {
    margin-left: -27%;
    width: 217% !important;
  }
  #categoria {
    margin-top: 2% !important;
  }
  input#imagem {
    width: 186% !important;
  }
  #grupo {
    width: 216% !important;
    margin-right: 10%;
  }
  .has-login p {
    margin-left: 55%;
    margin-top: 2%;
  }
}
</style>
