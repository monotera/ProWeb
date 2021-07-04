import React, { useState } from "react";
import Accordion from "./components/Accordion";
import Search from "./components/Search";
import Drop from "./components/Drop";
import Translate from "./components/Translate";
import Route from "./components/Route";
import { items, options, lang } from "./Data";
import Header from "./components/Header";

// eslint-disable-next-line import/no-anonymous-default-export
export default () => {
  return (
    <div>
      <Header />
      <Route path="/">
        <Accordion items={items} />
      </Route>
      <Route path="/list">
        <Search />
      </Route>
      <Route path="/drop">
        <Drop options={options} />
      </Route>
      <Route path="/translate">
        <Translate options={lang} />
      </Route>
    </div>
  );
};
