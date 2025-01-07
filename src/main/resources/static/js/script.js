$( function() {
	$("#datepicker").datepicker();
	$("#resizable").resizable();
	$(".controlgroup").controlgroup()
	$(".controlgroup-vertical").controlgroup({"direction": "vertical"});
	var availableTags = [
		"ActionScript",
		"AppleScript",
		"Asp",
		"BASIC",
		"C",
		"C++",
		"Clojure",
		"COBOL",
		"ColdFusion",
		"Erlang",
		"Fortran",
		"Groovy",
		"Haskell",
		"Java",
		"JavaScript",
		"Lisp",
		"Perl",
		"PHP",
		"Python",
		"Ruby",
		"Rust",
		"Scala",
		"Scheme"
	];
	$("#lang_predict").autocomplete({source: availableTags});

	$(document).tooltip();

	
	function hexFromRGB(r, g, b) {
		var hex = [r.toString(16), g.toString(16), b.toString(16)];
	    $.each( hex, function( nr, val ) {
			if ( val.length === 1 ) {
				hex[ nr ] = "0" + val;
			}
		});
	    return hex.join("").toUpperCase();
	}

	function refreshSwatch() {
		var red = $("#red_slider").slider("value"),
	      green = $("#green_slider").slider("value"),
	      blue = $("#blue_slider").slider("value"),
	      hex = hexFromRGB(red, green, blue);
		$("#swatch").css("background-color", "#" + hex );
	}
	 
	$("#red_slider, #green_slider, #blue_slider").slider({
		orientation: "horizontal",
	    range: "min",
	    max: 255,
	    value: 127,
	    slide: refreshSwatch,
	    change: refreshSwatch
	});
	$("#red_slider").slider("value", 255 );
	$("#green_slider").slider("value", 140 );
	$("#blue_slider").slider("value", 60 );
} );