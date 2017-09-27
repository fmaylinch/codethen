
console.log("start!");

const array = [1, 2, 3, 4, 5]; // int[] array = {1, 2, 3, 4, 5};
console.log("Numbers:", array);

const evens = array.filter( x => x % 2 == 0 );
console.log("Evens:", evens);

const names = ["peter", "mart", "anthony"];
console.log("Names:", names);

const nameLengths = names.map( name => name.length );
console.log("Lengths:", nameLengths);

const sum = array.reduce( (acc, next) => acc + next, 0 );
console.log("Sum:", sum);
