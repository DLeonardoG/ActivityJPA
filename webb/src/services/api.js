const BASE_URL = 'http://localhost:5173/';

export const fetchData = async (endpoint) => {
  try {
    const response = await fetch(`${BASE_URL}/${endpoint}`);
    const data = await response.json();
    return data;
  } catch (error) {
    console.error('Error fetching data:', error);
    return [];
  }
};

export const fetchItem = async (endpoint, id) => {
  try {
    const response = await fetch(`${BASE_URL}/${endpoint}/${id}`);
    const data = await response.json();
    return data;
  } catch (error) {
    console.error('Error fetching item:', error);
    return null;
  }
};
