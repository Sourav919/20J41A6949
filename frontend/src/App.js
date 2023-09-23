import React, { useState, useEffect } from "react";

export default function App() {
  const [data, setData] = useState([]);

  // Define a state variable to track loading and error states
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  // Define the API endpoint URL
  const apiUrl = "http://localhost:8080/trains"; // Replace with your API URL

  useEffect(() => {
    // Fetch data from the API when the component mounts
    fetch(apiUrl)
      .then((response) => {
        if (!response.ok) {
          throw new Error("Network response was not ok");
        }
        return response.json();
      })
      .then((responseData) => {
        setData(responseData); // Update the data state with the fetched data
        setLoading(false); // Set loading to false
      })
      .catch((error) => {
        setError(error); // Set error state if there's an error
        setLoading(false); // Set loading to false
      });
  }, []); // The empty array as the second argument makes this useEffect run once when the component mounts

  // Render loading state if data is still loading
  if (loading) {
    return <div>Loading...</div>;
  }

  // Render error state if there was an error
  if (error) {
    return <div>Error: {error.message}</div>;
  }

  // Render the fetched data
  return (
    <div>
      <h1>List of Trains</h1>
      <ul>
        {data.map((item, index) => (
          <li key={index}>{item.trainName}</li> // Assuming each object has a 'name' property
        ))}
      </ul>
    </div>
  );
}
