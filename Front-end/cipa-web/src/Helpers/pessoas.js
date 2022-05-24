import api from "../services";

export const getAll = async () => api('GET', 'pessoas')
  .then(({ data }) => data);

export const getForOne = async (id) => api('GET', `pessoas/${id}`)
  .then(({ data }) => data);

export const add = async (description) => api('POST', 'pessoas', { description })
  .then(getAll);

export const rm = async (id) => api('DELETE', `pessoas/${id}`)
  .then(getForOne);

export const put = async (id, description, check) => api('PUT', `pessoas/${id}`, { description, check })
  .then(getAll);
