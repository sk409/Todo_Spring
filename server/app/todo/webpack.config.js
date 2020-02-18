const jsSrcDir = "./src/main/resources/js/";
const VueLoaderPlugin = require("vue-loader/lib/plugin");

module.exports = (env, args) => {
    const devmode = args.mode === "development";
    return {
        devtool: devmode ? "source-map" : "none",
        entry: {
            app: jsSrcDir + "app.js",
            dashboard: jsSrcDir + "dashboard.js",
            register: jsSrcDir + "register.js",
        },
        module: {
            rules: [{
                    test: /\.vue$/,
                    loader: "vue-loader"
                },
                {
                    test: /\.js$/,
                    exclude: /(node_modules|bower_components)/,
                    use: {
                        loader: "babel-loader",
                        options: {
                            presets: ["@babel/preset-env"]
                        }
                    }
                },
                {
                    test: /\.css$/,
                    use: ["style-loader", "vue-style-loader", "css-loader"]
                },
                {
                    test: /\.scss/,
                    use: ["style-loader", "css-loader", "sass-loader"]
                }
            ]
        },
        output: {
            filename: "[name].js",
            path: __dirname + "/src/main/resources/static/js"
        },
        plugins: [new VueLoaderPlugin()],
        resolve: {
            extensions: [".js", ".vue"],
            alias: {
                vue$: "vue/dist/vue.esm.js"
            }
        }
    };
};