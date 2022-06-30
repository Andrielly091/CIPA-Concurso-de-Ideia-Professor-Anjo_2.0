<template>
  <div>
    <nav>
      <div class="nav-wrapper">
        <a href="#" class="brand-logo"
          ><img src="https://i.imgur.com/N2uQg4X.png" style="width: 85px"
        /></a>
        <ul id="nav-mobile" class="right hide-on-med-and-down">
          <li><a v-on:click="sair()" href="sass.html">Inicio</a></li>
          <li>
            <a v-on:click="irParaProjetos()" href="badges.html">Projetos</a>
          </li>
          <li><a v-on:click="inscricao()" href="#">Inscrever</a></li>
          <li style="float: right; position: absolute; right: 10px">
            <a v-on:click="sair()" href="#">Sair</a>
          </li>
        </ul>
      </div>
    </nav>
    <h1>CIPA</h1>
    <p class="resumo">
      O cipa (Concurso de ideias professor anjo), é uma plataforma web que tem
      como objeto realizar a inscrição de projetos e ideias dos alunos, e gerar
      uma votação para cada ideia/projeto apresentado, fazer o cadastros dos
      alunos e projetos,também com a banca de júri que irá avaliar e dar uma
      certa pontuação. Tendo como objetivo incentivar a criatividade e
      inovações, resoluções de problemas da nossa sociedade.
    </p>

    <p class="resumo2">
      Integrantes: <br />
      Andrielly Firmino; <br />
      Joás José; <br />
      Jadeilson Martinho; <br />
      Lavínia Wiliane.
    </p>

    <iframe
      width="620"
      height="315"
      src="https://www.youtube.com/embed/tgbNymZ7vqY"
    >
    </iframe>
  </div>
  <button
    id="btntt"
    class="btn waves-effect waves-light"
    type="submit"
    name="action"
  >
    SUBIMETER
  </button>

  <input class="inputt" type="" />

  <p class="p">Insira sua nota:</p>
</template>

<style>
@media (max-width: 720px) {
  p.resumo {
    font-weight: bold;
    width: 195% !important;
    margin-left: -45%;
  }
  iframe {
    margin-left: 11% !important;
    width: 85%;
    margin-top: 0% !important;
  }
  p.resumo2 {
    margin-top: 6%;
    margin-left: 40% !important;
    width: 45% !important;
  }
  input.inputt {
    margin-top: -85% !important;
    margin-left: 32% !important;
    width: 15% !important;
  }
  #btntt {
    margin-top: 29% !important;
    margin-left: 65% !important;
    width: 25% !important;
  }

  .p {
    margin-left: 52% !important;
    font-weight: bold;
    margin-top: -37% !important;
  }
}
.brand-logo {
  margin-left: 23%;
  width: 45% !important;
  margin-top: -13px;
}
.nav-wrapper {
  margin-left: -29%;
}
.logo {
  width: 40px;
}
ul {
  margin-right: 58% !important;
}

.p {
  margin-left: 52% !important;
  font-weight: bold;
  margin-top: -8%;
}
.logo {
  width: 4%;
}

.nav-wrapper {
  background: #45b1ff;
}
h1 {
  font-weight: bold;
}
.resumo {
  font-weight: bold;
  padding: 10px 280px;
}
.resumo2 {
  font-weight: bold;
  margin-left: 75%;
  margin-top: 9%;
}
iframe {
  margin-left: 22%;
  margin-top: -16%;
}
input {
  margin-left: -22%;
  width: 5%;
  margin-top: 8%;
}
button {
  margin-left: 55%;
  margin-top: 1.5%;
}
#btntt {
  background: #1b2f49;
}
</style>
<script>
//import { getAll } from '../Helpers/ideia';
import { setLocalStorge } from "../Helpers/localStore";
export default {
  name: "votacao",
  data() {
    return {};
  },
  mounted() {},
  methods: {
    sair() {
      setLocalStorge("auth", false);
      this.$router.push("/login");
    },
    irParaProjetos() {
      setLocalStorge("auth", false);
      this.$router.push("/");
    },
    inscricao() {
      this.$router.push("/inscricaoProjeto");
    },
  },
};
</script>





        




        