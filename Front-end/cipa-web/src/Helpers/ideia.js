import api from "../services";

export const getAll = async () => api('GET', 'ideias')
  .then(({ data }) => data);

export const getForOne = async (id) => api('GET', `ideias/${id}`)
  .then(({ data }) => data);

export const add = async (description) => api('POST', 'ideias', { description })
  .then(getAll);

export const rm = async (id) => api('DELETE', `ideias/${id}`)
  .then(getForOne);

export const put = async (id, description, check) => api('PUT', `ideias/${id}`, { description, check })
  .then(getAll);
