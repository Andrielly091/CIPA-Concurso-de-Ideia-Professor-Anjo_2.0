<template>
  <div class="container-forms">
    <h3>Email para Recuperação de senha:</h3>
    <input
      type="email"
      name="email"
      v-model="email"
      placeholder="Digite seu email:"
      id=""
    />
    <button
      type="submit"
      v-on:click="confirmar()"
      :disabled="!/\S+@\S+\.\S+/.test(email)"
    >
      Confirmar
    </button>
    <br />
    <span v-if="isVisibled && /\S+@\S+\.\S+/.test(email)">
      Em breve retornaremos com o email para recuperação de sua senha!
    </span>
  </div>
</template>

<script>
// import ncrypt from 'ncrypt-js';
import { findByEmail } from "../Helpers/pessoas";
import { sendEmail } from "../Helpers/email";
export default {
  name: "emailUser",
  data() {
    return {
      email: "",
      isVisibled: false,
    };
  },
  methods: {
    async confirmar() {
      this.isVisibled = true;
      const data = await findByEmail(this.email);
      if (data.found === "true") {
        const pessoa = data.pessoas[0];
        const link = `http://localhost:8082/senha/${pessoa.id}`;
        const email = pessoa.email;
        const msg = `
          Não responda esse email.
          Para resgatar sua senha click no seguinte link ${link}
          `;
        sendEmail({
          from: "jadeilsom.m@gmail.com",
          to: email,
          text: msg,
          subject: "recuperar senha",
        });
      }
    },
  },
};
</script>

<style>
.container-forms {
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 35%;
  height: 80vh;
  margin: 0 auto;
  padding: 7px;
  margin-top: 55px;
}

input,
button {
  margin-top: 20px;
  padding: 7px;
}

button {
  margin-top: 35px;
  width: 80%;
}
</style>