import axios from 'axios'

const HOST = 'localhost'
const PORT = 8081

const fetch = axios.create({
  baseURL: `http://${HOST}:${PORT}`,
  timeout: 1500,
  headers: {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
  }
})

const apiEmail = async (method, endpoint, body) => fetch
  .request({ method, url: endpoint, data: body})
  .then(({status, data}) => ({ status, data }))

export default apiEmail;
