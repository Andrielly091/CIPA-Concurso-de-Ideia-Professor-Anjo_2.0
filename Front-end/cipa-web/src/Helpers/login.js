import api from "../services";

export const getAll = async () => api('GET', 'login')
  .then(({ data }) => data);

export const getForOne = async (id) => api('GET', `login/${id}`)
  .then(({ data }) => data);

export const add = async (description) => api('POST', 'login', { description })
  .then(getAll);

export const rm = async (id) => api('DELETE', `login/${id}`)
  .then(getForOne);

export const put = async (id, description, check) => api('PUT', `login/${id}`, { description, check })
  .then(getAll);
