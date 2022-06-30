import apiEmail from "../services/email"

export const sendEmail = async (description) => await apiEmail('POST', 'api/email', description)
  .then(() => true)