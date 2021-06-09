import "./App.css";

function App() {
  const btnText = "Click me!";
  return (
    <div className="App">
      <label className="label" htmlFor="name">
        Enter name:
      </label>
      <input id="name" type="text" />
      <button
        style={{
          backgroundColor: "lightblue",
          color: "white",
          border: "1px solid blue",
        }}
      >
        {btnText}
      </button>
    </div>
  );
}

export default App;
