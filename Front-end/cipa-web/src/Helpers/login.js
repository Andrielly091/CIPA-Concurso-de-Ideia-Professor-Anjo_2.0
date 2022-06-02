import api from "../services";

export const getAll = async () => await api('GET', 'login')
  .then(({ data }) => data);

export const getForOne = async (id) => api('GET', `login/${id}`)
  .then(({ data }) => data);

export const addLogin = async (description) => await api('POST', 'login/', description)
  .then(({ data }) => data);

export const add = async (description) => await api('POST', 'login', description)
  .then(({ data }) => data);

export const rm = async (id) => api('DELETE', `login/${id}`)
  .then(getForOne);

export const put = async (id, description, check) => api('PUT', `login/${id}`, { description, check })
  .then(getAll);
