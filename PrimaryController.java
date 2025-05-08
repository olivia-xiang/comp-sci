package summative;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import javafx.embed.swing.SwingFXUtils;
import javax.imageio.ImageIO;

public class PrimaryController {

    private Stage stage;
    private Image originalImage; // Use this to keep track of the original image

    @FXML
    private ImageView imageView;

    @FXML
    private MenuItem openImage;

    @FXML
    private MenuItem saveImage;

    @FXML
    private MenuItem horizontalFlip;

    @FXML
    void onOpenImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image File");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.bmp", "*.gif"));

        try {
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                Image image = new Image(file.toURI().toString());
                originalImage = image;
                imageView.setImage(image);
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Image Load Failed");
            alert.setContentText("There was a problem opening your image");
            alert.showAndWait();
        }
    }

    @FXML
    public void onSaveImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Image");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG files", "*.png"));
        File file = fileChooser.showSaveDialog(imageView.getScene().getWindow());

        if (file != null) {
            WritableImage writableImage = imageView.snapshot(null, null);
            try {
                ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png", file);
            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Image Save Failed");
                alert.setContentText("There was a problem saving your image");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void onHorizontalFlip(ActionEvent event) {
        int width = (int) imageView.getImage().getWidth();
        int height = (int) imageView.getImage().getHeight();

        WritableImage writableImage = new WritableImage(width, height);
        PixelReader reader = imageView.getImage().getPixelReader();
        PixelWriter writer = writableImage.getPixelWriter();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                writer.setColor(width - i - 1, j, reader.getColor(i, j));
            }
        }
        imageView.setImage(writableImage);
    }

    @FXML
    void onVerticalFlip(ActionEvent event) {
        int width = (int) imageView.getImage().getWidth();
        int height = (int) imageView.getImage().getHeight();

        WritableImage writableImage = new WritableImage(width, height);
        PixelReader reader = imageView.getImage().getPixelReader();
        PixelWriter writer = writableImage.getPixelWriter();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                writer.setColor(i, height - j - 1, reader.getColor(i, j));
            }
        }
        imageView.setImage(writableImage);
    }

    @FXML
    void onRotateFlip(ActionEvent event) {
        int width = (int) imageView.getImage().getWidth();
        int height = (int) imageView.getImage().getHeight();

        WritableImage writableImage = new WritableImage(width, height);
        PixelReader reader = imageView.getImage().getPixelReader();
        PixelWriter writer = writableImage.getPixelWriter();

        double cx = width / 2;
        double cy = height / 2;
       
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) { 
                
                double dx = Math.abs(i - cx);
                double dy = Math.abs(j - cy);
                writer.setColor((int)dx, (int)dy, reader.getColor(i, j));
                int[] corrds = new int[2];
                corrds[0] = (int)(dx * Math.cos(Math.toRadians(90)) - dy * Math.sin(Math.toRadians(90)) + cx);
                corrds[1] = (int)(dx * Math.sin(Math.toRadians(90)) + dy * Math.cos(Math.toRadians(90)) + cy);
                dx = (corrds[0] < width && corrds[0] >= 0) ? corrds[0] : -1;
                dy = (corrds[1] < height && corrds[1] >= 0) ? corrds[1] : -1;
                if (dx >= 0 && dy >= 0) {
                    writer.setColor((int)dx, (int)dy, reader.getColor(i, j));
                }
                    
            }
        }
        imageView.setImage(writableImage);
    }

    @FXML
    void onGrayScale(ActionEvent event) {
        int width = (int) imageView.getImage().getWidth();
        int height = (int) imageView.getImage().getHeight();

        WritableImage writableImage = new WritableImage(width, height);
        PixelReader reader = imageView.getImage().getPixelReader();
        PixelWriter writer = writableImage.getPixelWriter();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color color = reader.getColor(i, j);
                double grey = color.getRed() * 0.21 + color.getGreen() * 0.71 + color.getBlue() * 0.07;
                writer.setColor(i, j, new Color(grey, grey, grey, 1));
            }
        }
        imageView.setImage(writableImage);
    }

    @FXML
    void onSepia(ActionEvent event) {
        int width = (int) imageView.getImage().getWidth();
        int height = (int) imageView.getImage().getHeight();

        WritableImage writableImage = new WritableImage(width, height);
        PixelReader reader = imageView.getImage().getPixelReader();
        PixelWriter writer = writableImage.getPixelWriter();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color color = reader.getColor(i, j);
                double[] rgb = new double[3];
                rgb[0] = color.getRed() * 0.393 + color.getGreen() * 0.769 + color.getBlue() * 0.189;
                rgb[1] = color.getRed() * 0.349 + color.getGreen() * 0.686 + color.getBlue() * 0.168;
                rgb[2] = color.getRed() * 0.272 + color.getGreen() * 0.534 + color.getBlue() * 0.131;
                for (int k = 0; k < 3; k++) {
                    rgb[k] = (rgb[k] > 1 ? 1 : rgb[k]);
                }
                writer.setColor(i, j, new Color(rgb[0], rgb[1], rgb[2], 1));
            }
        }
        imageView.setImage(writableImage);
    }
    @FXML
    void onInvertColor(ActionEvent event) {
        int width = (int) imageView.getImage().getWidth();
        int height = (int) imageView.getImage().getHeight();

        WritableImage writableImage = new WritableImage(width, height);
        PixelReader reader = imageView.getImage().getPixelReader();
        PixelWriter writer = writableImage.getPixelWriter();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color color = reader.getColor(i, j);
                Color invert = new Color (1 - color.getRed(), 1 - color.getGreen(), 1 - color.getBlue(), 1);
                writer.setColor(i, j, invert);
            }
        }
        imageView.setImage(writableImage);
    }

    @FXML
    void onBrightness(ActionEvent event) {
        int width = (int) imageView.getImage().getWidth();
        int height = (int) imageView.getImage().getHeight();

        WritableImage writableImage = new WritableImage(width, height);
        PixelReader reader = imageView.getImage().getPixelReader();
        PixelWriter writer = writableImage.getPixelWriter();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color color = reader.getColor(i, j);
                double[] rgb = {color.getRed() + 0.2, color.getGreen() + 0.2, color.getBlue() + 0.2};
                for (int k = 0; k < 3; k++) {
                    rgb[k] = rgb[k] > 1 ? 1 : rgb[k];
                }
                Color invert = new Color (rgb[0], rgb[1], rgb[2], 1);
                writer.setColor(i, j, invert);
            }
        }
        imageView.setImage(writableImage);
    }

    @FXML
    void onBulge(ActionEvent event) {
        int width = (int) imageView.getImage().getWidth();
        int height = (int) imageView.getImage().getHeight();

        WritableImage writableImage = new WritableImage(width, height);
        PixelReader reader = imageView.getImage().getPixelReader();
        PixelWriter writer = writableImage.getPixelWriter();

        double cx = width / 2;
        double cy = height / 2;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                
                double dx = i - cx;
                double dy = j - cy;
                double r = Math.sqrt(dx * dx + dy * dy);
                double angle = Math.atan2(dy, dx);
                r = Math.pow(r, 1.6) / 30;
                
                double x = cx + r * Math.cos(Math.toRadians(angle));
                double y = cy + r * Math.sin(Math.toRadians(angle));

                if (x >= 0 && x <= width && y >= 0 && y <= height) {
                     writer.setColor((int)x, (int)y, reader.getColor(i, j));
                }
               
            }
        }
        imageView.setImage(writableImage);
    }

    /*
     * Accessing a pixels colors
     * 
     * Color color = reader.getColor(x, y);
     * double red = color.getRed();
     * double green = color.getGreen();
     * double blue = color.getBlue();
     */

    /*
     * Modifying a pixels colors
     * 
     * Color newColor = new Color(1.0 - red, 1.0 - green, 1.0 - blue,
     * color.getOpacity());
     */

    // DO NOT REMOVE THIS METHOD!
    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
