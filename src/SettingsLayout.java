import javax.swing.*;
import java.awt.*;

public class SettingsLayout
{

    private JPanel hack( JComponent component )
    {
        JPanel panel = new JPanel( new GridLayout( 0, 1 ) );
        panel.add( component );
        return panel;
    }


    private JComponent indent( JComponent component )
    {
        component.setBorder( BorderFactory.createCompoundBorder( BorderFactory.createEmptyBorder( 0, 25, 0, 0 ), component.getBorder() ) );
        return component;
    }

    private void buildUI()
    {
        JPanel sectionOnePanel = new JPanel();
        BoxLayout sectionOneLayout = new BoxLayout( sectionOnePanel, BoxLayout.Y_AXIS );
        sectionOnePanel.setLayout( sectionOneLayout );
        sectionOnePanel.add( Box.createVerticalStrut( 5 ) );
        sectionOnePanel.add( indent( new JLabel( "Label One" ) ) );
        sectionOnePanel.add( Box.createVerticalStrut( 5 ) );
        sectionOnePanel.add( indent( new JLabel( "Label Two" ) ) );
        sectionOnePanel.setBorder( BorderFactory.createTitledBorder( BorderFactory.createMatteBorder( 2, 0, 0, 0, Color.ORANGE ), "Section One" ) );
        sectionOnePanel.setAlignmentX( 0 );

        JPanel sectionTwoPanel = new JPanel();
        BoxLayout sectionTwoLayout = new BoxLayout( sectionTwoPanel, BoxLayout.Y_AXIS );
        sectionTwoPanel.add( Box.createVerticalStrut( 5 ) );
        sectionTwoPanel.setLayout( sectionTwoLayout );
        sectionTwoPanel.add( indent(  new JLabel( "Another Label" )) );
        sectionTwoPanel.setBorder( BorderFactory.createTitledBorder( BorderFactory.createMatteBorder( 2, 0, 0, 0, Color.ORANGE ), "Section Two" ) );
        sectionTwoPanel.setAlignmentX( 0 );

        JPanel sectionThreePanel = new JPanel();
        BoxLayout sectionThreeLayout = new BoxLayout( sectionThreePanel, BoxLayout.Y_AXIS );
        sectionThreePanel.setLayout( sectionThreeLayout );
        sectionThreePanel.add( Box.createVerticalStrut( 5 ) );
        sectionThreePanel.add( indent( new JLabel( "YA Label" ) ) );
        sectionThreePanel.add( Box.createVerticalStrut( 5 ) );
        sectionThreePanel.add( indent( new JLabel( "DA Label" ) ) );
        sectionThreePanel.add( Box.createVerticalStrut( 5 ) );
        JCheckBox checking = new JCheckBox( "Checking" );
        checking.setBorder(BorderFactory.createEmptyBorder() );
        sectionThreePanel.add( indent( checking ) );
        sectionThreePanel.setBorder( BorderFactory.createTitledBorder( BorderFactory.createMatteBorder( 2, 0, 0, 0, Color.ORANGE ), "Section Two" ) );
        sectionThreePanel.setAlignmentX( 0 );

        JPanel contentPane = new JPanel();
        GroupLayout groupLayout = new GroupLayout( contentPane );
        contentPane.setLayout( groupLayout );
        groupLayout.setAutoCreateGaps( true );
        groupLayout.setHorizontalGroup( groupLayout.createParallelGroup()
                .addComponent( sectionOnePanel, 30, 300, Integer.MAX_VALUE )
                .addComponent( sectionTwoPanel, 30, 300, Integer.MAX_VALUE )
                .addComponent( sectionThreePanel, 30, 300, Integer.MAX_VALUE )
        );
        groupLayout.setVerticalGroup( groupLayout.createSequentialGroup()
                .addComponent( sectionOnePanel )
                .addComponent( sectionTwoPanel )
                .addComponent( sectionThreePanel )
        );
        contentPane.setBorder( BorderFactory.createEmptyBorder(5,5,5,5) );
//        BoxLayout boxLayout = new BoxLayout( contentPane, BoxLayout.Y_AXIS );
//        contentPane.setLayout( boxLayout );
//        contentPane.add( hack( sectionOnePanel ) );
//        contentPane.add( hack( sectionTwoPanel ) );
//        contentPane.add( hack( sectionThreePanel ) );
//        contentPane.add( Box.createVerticalGlue() );

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );

        frame.setContentPane( contentPane );
        frame.pack();
        frame.setVisible( true );
    }


    public static void main( String[] args )
    {
        SettingsLayout testing = new SettingsLayout();
        SwingUtilities.invokeLater( testing::buildUI );
    }
}
