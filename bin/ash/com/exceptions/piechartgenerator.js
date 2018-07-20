function dashboard(id, fData) {
	var barColor = 'steelblue';
	function segColor(c) {
		return {
			ppm : "#807dba",
			app : "#e08214",
			matching : "#41ab5d"
		}[c];
	}

	// compute total for each state.
	fData.forEach(function(d) {
		d.total = d.freq.ppm + d.freq.app + d.freq.matching;
	});

	// function to handle histogram.
	function histoGram(fD) {
		var hG = {}, hGDim = {
			t : 60,
			r : 0,
			b : 30,
			l : 0
		};
		hGDim.w = 100 - hGDim.l - hGDim.r, hGDim.h = 300 - hGDim.t - hGDim.b;

		// create svg for histogram.
		var hGsvg = d3.select(id).append("svg").attr("width",
				hGDim.w + hGDim.l + hGDim.r).attr("height",
				hGDim.h + hGDim.t + hGDim.b).append("g").attr("transform",
				"translate(" + 0 + "," + 0 + ")").append("tick").attr("opacity", 0);

		// create function for x-axis mapping.
		var x = d3.scale.ordinal().rangeRoundBands([ 0, hGDim.w ], 0.1).domain(
				fD.map(function(d) {
					return d[0];
				}));

		// Add x-axis to the histogram svg.
		hGsvg.append("g").attr("class", "x axis").attr("transform",
				"translate(0," + hGDim.h + ")").call(
				d3.svg.axis().scale(x).orient("bottom"));

		// Create function for y-axis map.
		var y = d3.scale.linear().range([ hGDim.h, 0 ]).domain(
				[ 0, d3.max(fD, function(d) {
					return d[1];
				}) ]);

		// Create bars for histogram to contain rectangles and freq
		// labels.
		/*var bars = hGsvg.selectAll(".bar").data(fD).enter().append("g").attr(
				"class", "bar");*/

		// create the rectangles.
		/*bars.append("rect").attr("x", function(d) {
			return x(d[0]);
		}).attr("y", function(d) {
			return y(d[1]);
		}).attr("width", x.rangeBand()).attr("height", function(d) {
			return hGDim.h - y(d[1]);
		}).attr('fill', barColor);*/
//		.on("mouseover", mouseover);// mouseover
		// is
		// defined
		// below.

		// Create the frequency labels above the rectangles.
		/*bars.append("text").text(function(d) {
			return d3.format(",")(d[1])
		}).attr("x", function(d) {
			return x(d[0]) + x.rangeBand() / 2;
		}).attr("y", function(d) {
			return y(d[1]) - 5;
		}).attr("text-anchor", "middle");*/

		/*function mouseover(d) { // utility function to be called on
			// mouseover.
			// filter for selected state.
			var st = fData.filter(function(s) {
				return s.State == d[0];
			})[0], nD = d3.keys(st.freq).map(function(s) {
				return {
					type : s,
					freq : st.freq[s]
				};
			});

			// call update functions of pie-chart and legend.
			pC.update(nD);
			leg.update(nD);
		}*/

		/*function mouseout(d) { // utility function to be called on
			// mouseout.
			// reset the pie-chart and legend.
			pC.update(tF);
			leg.update(tF);
		}*/

		// create function to update the bars. This will be used by
		// pie-chart.
		hG.update = function(nD, color) {
			// update the domain of the y-axis map to reflect change in
			// frequencies.
			y.domain([ 0, d3.max(nD, function(d) {
				return d[1];
			}) ]);

			// Attach the new data to the bars.
			var bars = hGsvg.selectAll(".bar").data(nD);

			// transition the height and color of rectangles.
			bars.select("rect").transition().duration(500).attr("y",
					function(d) {
						return y(d[1]);
					}).attr("height", function(d) {
				return hGDim.h - y(d[1]);
			}).attr("fill", color);

			// transition the frequency labels location and change
			// value.
			bars.select("text").transition().duration(500).text(function(d) {
				return d3.format(",")(d[1])
			}).attr("y", function(d) {
				return y(d[1]) - 5;
			});
		}
		return hG;
	}

	// function to handle pieChart.
	function pieChart(pD) {
		var pC = {}, pieDim = {
			w : 250,
			h : 250
		};
		pieDim.r = Math.min(pieDim.w, pieDim.h) / 2;

		// create svg for pie chart.
		var piesvg = d3.select(id).append("svg").attr("width", pieDim.w).attr(
				"height", pieDim.h).append("g").attr("transform",
				"translate(" + pieDim.w / 2 + "," + pieDim.h / 2 + ")");
				 
	 

		// create function to draw the arcs of the pie slices.
		var arc = d3.svg.arc().outerRadius(pieDim.r - 10).innerRadius(0);

		// create a function to compute the pie slice angles.
		var pie = d3.layout.pie().sort(null).value(function(d) {
			return d.freq;
		});

		// Draw the pie slices.
		piesvg.selectAll("path").data(pie(pD)).enter().append("path").attr("d",
				arc).each(function(d) {
			this._current = d;
		}).style("fill", function(d) {
			return segColor(d.data.type);
		}).text(function(d) { return d.value; }).on("mouseover", mouseover).on("mouseout", mouseout).on("click",
				mouseclick);		
		
		
		// create function to update pie-chart. This will be used by
		// histogram.
		pC.update = function(nD) {
			piesvg.selectAll("path").data(pie(nD)).transition().duration(500)
					.attrTween("d", arcTween);
		}

		function mouseclick(d) {
			// call the update function of histogram with all data.
			//alert('line 173 >>> is called');
			//saveURL();
			var filter = d.data.type;
			var list2 = $("#list2").val();
			var list = $("#list").val();
			var inactive_user = $("#inactive_user").val();	
			var subProductId = $("#subProductNameID").val();
			var productId = $("#productId").val();
	
			lazy_load();
			function lazy_load() {
				//var name = $("#name").val();		
				var current_last_index = $("#current_last_index").val();
				//alert("current last index : "+current_last_index);
				if(current_last_index == "" || current_last_index == null) {
					current_last_index = 0;
				}
				
				// ajax call for report table generate on summary_graph_selection page
				//url :  /* [[@{/}]] */'a/summary_graph_selection?productId='+encodeURIComponent(productId) + '&subProductId=' + encodeURIComponent(subProductId) + '&filter=' + encodeURIComponent(filter) + '&list=' + encodeURIComponent(list) + '&list2=' + encodeURIComponent(list2) + '&inactive_user=' + encodeURIComponent(inactive_user),		
				
				$.ajax({
					type : "GET",
					url :  /* [[@{/}]] */'a/users?productId='+encodeURIComponent(productId) + '&subProductId=' + encodeURIComponent(subProductId) + '&filter=' + encodeURIComponent(filter) + '&list=' + encodeURIComponent(list) + '&list2=' + encodeURIComponent(list2) + '&inactive_user=' + encodeURIComponent(inactive_user) + '&current_last_index=' + current_last_index,
					dataType : 'json',
	   				contentType : 'application/json',
	   				cache : false,
					success : function(data) {
						//var persons = data.persons;
						$('#summary_report').show();
						
	   					var counter = current_last_index;
	   					var user_data = '';
	   					//var total_pages = Math.ceil(data.length / data_per_page);		
	   					$('#number_of_entry').html("number of data : "+data.length);
	   					
	   					for(var i = 0; i < data.length; i ++) {
	   						user_data += '<tr class="table table-bordered table-hover table-striped">';
				    		user_data += '<td>' +(++counter)+ '</td>';
				    		user_data += '<td id="check-box"><input type="checkbox" name="user" value='+data[i].personId+'></td>';
							user_data += '<td>' +data[i].samAccount+ '</td>';
							user_data += '<td>' +data[i].valmetId+ '</td>';
							user_data += '<td>' +data[i].name+ '</td>';
							user_data += '<td>' +data[i].emailAddress+ '</td>';
							user_data += '<td>' +data[i].status+ '</td>';
							user_data += '<td>' +data[i].personId+ '</td>';
							user_data += '<td>' +data[i].nameHR+ '</td>';
							user_data += '<td>' +data[i].emailHR+ '</td>';
							user_data += '<td>' +data[i].statusHR+ '</td>';
							user_data += '<td>' +data[i].managerMainContactID+ '</td>';
							user_data += '<td>' +data[i].managerMainContactName+ '</td>';
							user_data += '<td>' +data[i].managerMainContactEmail+ '</td>';
							user_data += '</tr>';	
	   					}
	   					$("#report_table_body").html(user_data);
	   					
	   					$('#next').on('click', function() {
	   						$('input[name="current_last_index"]').val(counter);
	   						data = "";
	   						lazy_load();
	   					});
	   					
	   					//$('#number_of_pages').html("number of pages : "+total_pages);			
	   					//document.getElementById('summary_report').style.display = "inline";
	   					/*$.each(data, function(key, value) {
	   						
	   							user_data += '<tr class="table table-bordered table-hover table-striped">';
					    		user_data += '<td>' +(++counter)+ '</td>';
					    		user_data += '<td id="check-box"><input type="checkbox" name="user" value='+value.personId+'></td>';
								user_data += '<td>' +value.samAccount+ '</td>';
								user_data += '<td>' +value.valmetId+ '</td>';
								user_data += '<td>' +value.name+ '</td>';
								user_data += '<td>' +value.emailAddress+ '</td>';
								user_data += '<td>' +value.status+ '</td>';
								user_data += '<td>' +value.personId+ '</td>';
								user_data += '<td>' +value.nameHR+ '</td>';
								user_data += '<td>' +value.emailHR+ '</td>';
								user_data += '<td>' +value.statusHR+ '</td>';
								user_data += '<td>' +value.managerMainContactID+ '</td>';
								user_data += '<td>' +value.managerMainContactName+ '</td>';
								user_data += '<td>' +value.managerMainContactEmail+ '</td>';
								user_data += '</tr>';	
								$("#report_table_body").html(user_data);
	   					});	*/
	   									
	   				
					}
				});
			}
			
			
			
			/*window.location.replace( [[@{/}]] 'getReportFromSummaryGraph?productId='+productId+
					'&subProductId='+subProductId+'&filter='
					+ filter + '&list=' + list + '&list2=' + list2 
					+ '&inactive_user=' + inactive_user);*/
		}
		// Utility function to be called on mouseover a pie slice.
		function mouseover(d) {
			// call the update function of histogram with new data.
			hG.update(fData.map(function(v) {
				return [ v.State, v.freq[d.data.type] ];
			}), segColor(d.data.type));						
			
			var hoverText = null;
			if(d.data.type === 'ppm'){
				hoverText = 'Only in PPM ';
			}
			else if(d.data.type === 'app'){
				hoverText = 'Only in App ';
			}
			else{
				hoverText = 'Both matching ';
			}
			 d3.select("#dashboard")
		        .style("left", "500px")		        
		        .style("opacity", 1)
		        .select("#value")
		        .text(hoverText + d.value);
		}
		// Utility function to be called on mouseout a pie slice.
		function mouseout(d) {
			// call the update function of histogram with all data.
			hG.update(fData.map(function(v) {
				return [ v.State, v.total ];
			}), barColor);
		}
		// Animating the pie-slice requiring a custom function which
		// specifies
		// how the intermediate paths should be drawn.
		function arcTween(a) {
			var i = d3.interpolate(this._current, a);
			this._current = i(0);
			return function(t) {
				return arc(i(t));
			};
		}
		return pC;
	}

	// function to handle legend.
	function legend(lD) {
		var leg = {};

		// create table for legend.
		var legend = d3.select(id).append("table").attr('class', 'legend');

		// create one row per segment.
		var tr = legend.append("tbody").selectAll("tr").data(lD).enter()
				.append("tr");

		// create the first column for each segment.
		tr.append("td").append("svg").attr("width", '16').attr("height", '16')
				.append("rect").attr("width", '16').attr("height", '16').attr(
						"fill", function(d) {
							return segColor(d.type);
						});

		// create the second column for each segment.
		tr.append("td").text(function(d) {
			if(d.type === 'ppm'){
				return 'Only in PPM';
			}
			else if(d.type === 'app'){
				return 'Only in App';
			}
			else{
				return 'Both matching';
			}
		});

		// create the third column for each segment.
		tr.append("td").attr("class", 'legendFreq').text(function(d) {
			return d3.format(",")(d.freq);
		});

		// create the fourth column for each segment.
		/*tr.append("td").attr("class", 'legendPerc').text(function(d) {
			return getLegend(d, lD);
		});*/

		// Utility function to be used to update the legend.
		leg.update = function(nD) {
			// update the data attached to the row elements.
			var l = legend.select("tbody").selectAll("tr").data(nD);

			// update the frequencies.
			l.select(".legendFreq").text(function(d) {
				return d3.format(",")(d.freq);
			});

			// update the percentage column.
			/*l.select(".legendPerc").text(function(d) {
				return getLegend(d, nD);
			});*/
		}

			/*function getLegend(d, aD) { // Utility function to compute
				// percentage.
				return d3.format("."+2+"%")(d.freq / d3.sum(aD.map(function(v) {
					return v.freq;
				})));
			}*/
		
		function click(d) {
			// call the update function of histogram with all data.
			var filter = d.data.type;
			alert(filter);
			var name = $("#name").val();
			var list2 = $("#list2").val();
			var list = $("#list").val();
			var productId = $("#productId").val();
			var subProductId = $("#subProductId").val();
			
			window.location.replace(/* [[@{/}]] */'getReportFromSummaryGraph?productId='+productId+
					'&subProductId='+subProductId+'&filter='
					+ filter + '&list=' + list + '&list2=' + list2);
		}
		return leg;
	}

	// calculate total frequency by segment for all state.
	var tF = [ 'ppm', 'app', 'matching' ].map(function(d) {
		return {
			type : d,
			freq : d3.sum(fData.map(function(t) {
				return t.freq[d];
			}))
		};
	});

	// calculate total frequency by state for all segment.
	var sF = fData.map(function(d) {
		return [ d.State, d.total ];
	});

	var hG = histoGram(sF); // create the histogram.
	var pC = pieChart(tF), // create the pie-chart.
	leg = legend(tF); // create the legend.
}

