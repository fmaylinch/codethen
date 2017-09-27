
// Like in Java, creates a date with current time
const date = new Date();
console.log("Date:", date);
console.log("Millis from 1-1-1970:", date.getTime());

console.log("Date in our desired format: " + formatDate(date));


const millis = 0; // 0 is for 1-1-1970 GMT
const dateZero = new Date(millis);
// The date you see might be slightly different depending on your time zone
console.log("Date taken as starting point: " + dateZero);


function formatDate(date) {

	return date.getFullYear() +
		"-" + (date.getMonth()+1) + // Note we have to add 1 because January is 0
		"-" + date.getDate() +
		" " + date.getHours() +
		":" + date.getMinutes()
}