export const setLocalStorge = (key,value) => {
  localStorage.setItem(key, value);
}

export const getLocalStorage = (key) => {
  localStorage.getItem(key);
}