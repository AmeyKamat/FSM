var sampleInputFloor = {
  "layoutId": 1,
  "minimumX": 0,
  "maximumX": 12,
  "minimumY": 0,
  "maximumY": 22,
};

var sampleInputDesks = [  
   {  
      "tableUid":1,
      "layoutId":"testBook",
      "tableNumber":1,
      "rows":1,
      "columns":5,
      "topLeftX":1,
      "topLeftY":3,
      "deskString":"[[1,2,3,4,5]]"
   },
   {  
      "tableUid":2,
      "layoutId":"testBook",
      "tableNumber":2,
      "rows":1,
      "columns":5,
      "topLeftX":1,
      "topLeftY":6,
      "deskString":"[[6,7,8,9,10]]"
   },
   {  
      "tableUid":3,
      "layoutId":"testBook",
      "tableNumber":3,
      "rows":1,
      "columns":5,
      "topLeftX":1,
      "topLeftY":9,
      "deskString":"[[11,12,13,14,15]]"
   },
   {  
      "tableUid":4,
      "layoutId":"testBook",
      "tableNumber":4,
      "rows":1,
      "columns":1,
      "topLeftX":4,
      "topLeftY":19,
      "deskString":"[[10909000]]"
   },
   {  
      "tableUid":5,
      "layoutId":"testBook",
      "tableNumber":5,
      "rows":3,
      "columns":2,
      "topLeftX":7,
      "topLeftY":12,
      "deskString":"[[24,25,26],[35,36,37]]"
   },
   {  
      "tableUid":6,
      "layoutId":"testBook",
      "tableNumber":6,
      "rows":2,
      "columns":4,
      "topLeftX":10,
      "topLeftY":3,
      "deskString":"[[16,18,20,22],[17,19,21,23]]"
   },
   {  
      "tableUid":7,
      "layoutId":"testBook",
      "tableNumber":7,
      "rows":2,
      "columns":4,
      "topLeftX":10,
      "topLeftY":6,
      "deskString":"[[27,28,29,30],[31,32,33,34]]"
   },
   {  
      "tableUid":8,
      "layoutId":"testBook",
      "tableNumber":8,
      "rows":3,
      "columns":1,
      "topLeftX":10,
      "topLeftY":12,
      "deskString":"[[38,39,46]]"
   },
   {  
      "tableUid":9,
      "layoutId":"testBook",
      "tableNumber":9,
      "rows":1,
      "columns":4,
      "topLeftX":12,
      "topLeftY":17,
      "deskString":"[[40,41,42,43]]"
   },
   {  
      "tableUid":10,
      "layoutId":"testBook",
      "tableNumber":10,
      "rows":1,
      "columns":2,
      "topLeftX":12,
      "topLeftY":19,
      "deskString":"[[44,45]]"
   },
];

// var sampleInput = {
//   "layoutId": 1,
//   "minimum_x": 0,
//   "maximum_x": 10,
//   "minimum_y": 0,
//   "maximum_y": 10,
//   "tables": [
//     {
//       "x": 7,
//       "y": 3,
//       "width": 2,
//       "height": 2,
//       "desks":[
//         [
//           {
//             "deskid": 1,
//             "brid": ""
//           },
//           {
//             "deskid": 2,
//             "brid": ""
//           }
//         ],
//         [
//           {
//             "deskid": 6,
//             "brid": ""
//           }
//         ]
//       ]
//     }
//   ]
// };

var locationInfo = [
   { 
      name: "India",
      cities: [
         {
            name: "Pune",
            locations: [
               {
                  name: "kharadi",
                  floor: [1,2,3,4,5,6,7,8]
               },
               {
                  name: "hinjewadi",
                  floor: [1,2,3,4]
               }
            ]
         }
      ]
   },
   {
      name: "USA",
      cities: [
         {
            name: "Delaware",
            locations: [
               {
                  name: "Wilmington",
                  floor: [1,2,3,4]
               }
            ]
         }
      ]
   }
]