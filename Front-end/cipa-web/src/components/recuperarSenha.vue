<template>
  <div class="forms">
    <h1>Recuperar senha:</h1>
        <div class="row">
        <div class="input-field col s12">
            <i class="material-icons prefix">vpn_key</i>
            <input id="senha" v-model="senha" type="password" min=8  placeholder="Digite sua senha:">
          </div>
        </div>
        <div class="row">
          <div class="input-field col s12">
            <i class="material-icons prefix">vpn_key</i>
            <input id="Confirmasenha" v-model="confSenha" type="password" min=8 placeholder="Confirmar senha:">
          </div>
        </div>
        <button v-on:click="alterar()" :disabled="!confSenha || !senha || senha.length < 8 || confSenha.length < 8" class="btn waves-effect waves-light" type="submit" name="action">Confirmar
          <i class="material-icons right">send</i>
        </button>
  </div>
</template>
<script>
import { getForOne, put } from '../Helpers/pessoas'

export default {
  name: 'recuperarSenha',
  data() {
    return {
      senha: '',
      confSenha: '',
      idUser: this.$route.params.id
    }
  }, 
  methods: {
    async alterar() { 
      if (this.confSenha !== this.senha) {
        alert('Senhas diferentes')
      }
      const { pessoas } = await getForOne(this.idUser)
      const [upPessoa] = pessoas
      upPessoa.senha = this.senha
      console.log(upPessoa);
      await put(upPessoa)
      this.$router.push('/login')
    },
}
}
</script>
<style>
  h1 {
    text-align: center;
  }
  .forms {
    display: flex;
    flex-direction: column;
    height: 85vh;
    width: 25%;
    margin: 0 auto;
    margin-top: 45px;
    align-items: center;
  }
  button {
    width: 200px;
    margin: 0 auto;
    margin-bottom: 55px;
  }
  .row {
    width: 85%;
  }
</style>