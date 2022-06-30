import api from "../services";

export const getAll = async () => await api('GET', 'ideias')
  .then(({ data }) => data);

export const getForOne = async (id) => await api('GET', `ideias/${id}`)
  .then(({ data }) => data);

export const add = async (description) => api('POST', 'ideias/', description)
  .then(({data}) => data)
  .catch(({ response }) => response.data);

export const rm = async (id) => api('DELETE', `ideias/${id}`)
  .then(getForOne);

export const put = async (id, description, check) => api('PUT', `ideias/${id}`, { description, check })
  .then(getAll);
