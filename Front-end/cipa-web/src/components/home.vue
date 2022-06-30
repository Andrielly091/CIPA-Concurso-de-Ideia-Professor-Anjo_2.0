<template>
  <div>

    <nav>
      <div class="nav-wrapper">
        <a href="#" class="brand-logo"
        ><img src="https://i.imgur.com/N2uQg4X.png" style="width: 85px"
      /></a>
      <ul id="nav-mobile" class="right hide-on-med-and-down">
        <li><a href="sass.html">Inicio</a></li>
        <li><a href="badges.html">Projetos</a></li>
        <li><a v-on:click="irParaInscricao()" href="#">Inscrever</a></li>
        <li style="float: right; position: absolute; right: 10px">
          <a v-on:click="sair()" href="#">Sair</a>
        </li>
      </ul>
    </div>
  </nav>

  <div style="display: flex">
    <div id="quadros1" v-for="o in objeto" :key="o.id_ideia" class="card-group">
      <div class="card" style="width: 18rem">
        <img
          class="imagem"
          v-bind:src=" o.imagem "
          style="width: 80px"
          alt="Card image cap"
        />
        <div class="card-body">
          <h5 class="card-title">{{ o.nome }}</h5>
          <p class="card-text">
            {{ o.resumo_do_projeto }}
          </p>
          <a class="btn btn-primary">Votar</a>
          <a class="btn btn-primary">Leia mais</a>
        </div>
      </div>
    </div>
  </div>
  </div>

</template>

<script>
import { getAll } from "../Helpers/ideia";
import { setLocalStorge } from "../Helpers/localStore";

export default {
  name: "home",
  data() {
    return {
      objeto: [],
    };
  },
  props: {
    msg: String,
  },
  async mounted() {
    const data = await getAll();
    this.objeto = data;
  },
  methods: {
    sair() {
      setLocalStorge("auth", false);
      this.$router.push("/login");
    },
    irParaInscricao() {
      this.$router.push("/inscricaoProjeto");
    },
    detalhes(e) {
      console.log('value',e.target.value);
      const url = `/votacao/${e}`
      this.$router.push(url)
    },
    votar(e) {
      console.log('value',e.target.value)
      const url = `/votacao/${e}`
      this.$router.push(url)
    }
  },
};
</script>

<style scoped>
@media (max-width: 720px) {
  #quadros1 {
    height: 6px;
    margin-top: 0% !important;
    margin-left: -18% !important;
    border-radius: 7%;
    width: 400%;
  }

  .nav-wrapper {
    margin-left: -29%;
  }
}
#quadros1 {
  height: 6px;
  /* margin-top: -5% !important;
  margin-left: -35% !important; */
  border-radius: 7%;
  width: 400%;
}

* {
  padding: 0 !important;
  margin: 0 !important;
}
.imagem {
  margin-top: 0% !important;
  margin-left: 0% !important;
  border-radius: 7%;
}
.nav-wrapper {
  background-color: #45b1ff !important;
}
li {
  padding-right: 45px !important;
}
ul {
  margin-right: 5% !important;
}
.brand-logo {
  position: relative;
  top: -12px;
}
a:hover {
  background-color: transparent;
}
.card {
  margin-top: 5% !important;
  margin-left: 10% !important;
  border-radius: 7%;
  background-color: rgba(151, 151, 151, 0.1);
}
.btn-primary {
  margin-bottom: 12% !important;
  margin-top: 7% !important;
  margin-left: 13% !important;
  background-color: #4c6fff !important;
  padding-left: 10px !important;
  padding-right: 10px !important;
}
.card-group {
  display: flex;
}
.card-title {
  margin-top: 5% !important;
  margin-left: 28% !important;
}
.card-text {
  margin-top: 5% !important;
  width: 88%;
  margin-left: 8% !important;
}
.Header-link {
  margin-left: 95% !important;
  margin-top: -10% !important;
}
#sair {
  margin-top: -10% !important;
}
</style>
