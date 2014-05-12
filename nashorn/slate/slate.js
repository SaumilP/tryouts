#!/usr/bin/jjs -fv

if ( arguments.length === 0 ){
	print("Usage: slate.js -- [INPUT_DIR] [OUTPUT_DIR]");
}

var inputDir = arguments[0], outputDir = arguments[1];
if ( undefined === inputDir ) {
	inputDir = "./inputDir";
	print("Reading from ${inputDir}");
}

if ( undefined === outputDir ) {
	outputDir = "./outputDir";
	print("Writing to ${outputDir}");
}

var homeDir = $ENV.STATIC_PAGE_GENERATOR_HOME;
if ( undefined === homeDir ){
	print("No STATIC_PAGE_GENERATOR_HOME is defined, using the current directory");
	homeDir = ".";
}

var Files = Java.type("java.nio.file.Files");
var Paths = Java.type("java.nio.file.Paths");
var StringType = Java.type("java.lang.String");
var fileExt = ".html";
var debug = false;
var paramExtension = ".json";

// Loads <code>Mustache.js</code> from lib directory
load("${homeDir}/lib/mustache.js");
generate();

/**
* Method reads files from directories and generates Static Pages.
*/
function generate() {
	print("Reading from ${inputDir}, about to start Static Page Generation...");
	var directories = Files.newDirectoryStream(Paths.get(inputDir), "*${fileExt}").iterator();

	while( directories.hasNext() ){
		var fileName = directories.next().getFileName().toString();
		print("File: " + fileName);

		var extIndex = fileName.indexOf(fileExt);
		var fileWOExtension = fileName.substring(0, extIndex);
		if ( debug ){
			print("File without extension ${fileWOExtension}");
		}

		write(
			processFile( readFile(fileName), loadParameters(fileWOExtension) ), fileName
		);
	}
}

/**
* Method reads supplied file
*/
function readFile(file) {
	print("Reading ${file}");
	return String( new StringType(Files.readAllBytes( Paths.get("${inputDir}/${file}"), "UTF-8") );
}

/**
*	Loads Parameters from file
*/
function loadParameters(file){
	var content = readFile("${file}${paramExtension}")
	print( content );
	return JSON.parse( content );
}

/**
* Uses Mustache for rendering and returns rendered content.
*/
function processFile(content, parameters ){
	if( debug ){
		print("Processing: ${content} with ${parameters}");
	}

	var output = Mustache.render(content, parameters);

	if( debug ){
		print("Rendered ${output}");
	}
	return output;
}

/**
*	Write rendered content in file
*/
function write( content, file){
	var outputFile = "${outputDir}/${file}";
	if(debug){
		print("Content Type: " + typeof content);
		print("About to write ${content} to ${outputFile}");
	}
	Files.write( Paths.get(output), new StringType(content).bytes );
}