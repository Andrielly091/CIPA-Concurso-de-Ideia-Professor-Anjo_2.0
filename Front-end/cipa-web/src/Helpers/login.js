import api from "../services";

export const auth = async (description) => await api('POST', 'login', description)
  .then(({ data }) => data)
  .catch(({ response }) => response.data)
