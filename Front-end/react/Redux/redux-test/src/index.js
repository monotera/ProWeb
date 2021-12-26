import store from "./store";

import { bugAdded, bugResolved } from "./actions";

store.dispatch(bugAdded("bug1"));
store.dispatch(bugAdded("bug2"));
console.log(store.getState());
store.dispatch(bugResolved(1));
console.log(store.getState());
